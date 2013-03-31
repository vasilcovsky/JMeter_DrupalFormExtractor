package md.scala.jmeter.extractor

import scala.collection.JavaConversions._

import org.apache.jmeter.processor.{PostProcessor}
import org.apache.jmeter.threads.{JMeterContext, JMeterContextService}
import org.apache.jmeter.testelement.{AbstractTestElement, TestElement}
import org.apache.jmeter.extractor.{JSoupExtractor}
import org.apache.jorphan.logging.{LoggingManager}

@SerialVersionUID(1L)
class DrupalFormExtractor extends AbstractTestElement with PostProcessor {

  lazy val extractor = new JSoupExtractor

  private final val NOT_FOUND = ""

  private final val FORM_NAME = "formName"
  
  private final val VAR_PREFIX = "varPrefix"

  def formName = getPropertyAsString(FORM_NAME)
  def formName_= (value: String) = setProperty(FORM_NAME, value)

  def varPrefix = getPropertyAsString(VAR_PREFIX)
  def varPrefix_= (value: String) = setProperty(VAR_PREFIX, value)

  def process() {
    val ctx = JMeterContextService.getContext
    val vars = ctx.getVariables
    val result = ctx.getPreviousResult
    val response = result.getResponseDataAsString

    Map(
      "form_id" -> "FORM_ID",
      "form_build_id" -> "FORM_BUILD_ID",
      "form_token" -> "FORM_TOKEN"
    )
    .mapValues { v => 
      if (varPrefix.isEmpty) v else "%s_%s".format(varPrefix, v)
    }
    .foreach { e =>
      val selector = if (formName.isEmpty)
          "input[name=%s]".format(e._1)
        else
          "form#%s input[name=%s]".format(formName, e._1)

      val value = extractValueAttr(selector, response).getOrElse(NOT_FOUND)
      vars.put(e._2, value)
    }

  }

  def extractValueAttr(selector: String, inputString: String): Option[String] = {
    val matches = new scala.collection.mutable.ListBuffer[String]
    //@TODO: Provide cache key
    extractor.extract(selector, "value", 1, inputString, matches, 0, null)
    matches.headOption
  }

}