package md.scala.jmeter.extractor.gui

import java.awt.{BorderLayout, Component, GridBagConstraints, GridBagLayout}

import javax.swing._

import org.apache.jmeter.processor.gui.{AbstractPostProcessorGui}
import org.apache.jmeter.testelement.{TestElement}
import org.apache.jorphan.gui.JLabeledTextField;

import md.scala.jmeter.extractor.{DrupalFormExtractor}

@SerialVersionUID(1L)
class DrupalFormExtractorGui extends AbstractPostProcessorGui with Constraints {

  private final val fieldFormName = new JLabeledTextField("Form ID: ")
  
  private final val fieldVarPrefix = new JLabeledTextField("Variable Prefix: ")

  private final val STATIC_LABEL = "Drupal Form Extractor"

  private final val RESOURCE_LABEL = "drupal_form_extractor_title"

  init

  def init() {
    setLayout(new BorderLayout)
    setBorder(makeBorder)

    val box = Box.createVerticalBox
    box.add(makeTitlePanel)
    box.add(makeParameterPanel, BorderLayout.CENTER)
    add(box, BorderLayout.NORTH)
  }

  override def createTestElement() = {
    val element = new DrupalFormExtractor
    modifyTestElement(element)
    element
  }

  override def modifyTestElement(te: TestElement) {
    configureTestElement(te)
    if (te.isInstanceOf[DrupalFormExtractor]) {
      val extractor = te.asInstanceOf[DrupalFormExtractor]
      extractor.varPrefix = fieldVarPrefix.getText()
      extractor.formName = fieldFormName.getText() 
    }
  }

  override def configure(te: TestElement) {
    super.configure(te)
    if (te.isInstanceOf[DrupalFormExtractor]) {
      val extractor = te.asInstanceOf[DrupalFormExtractor]
      fieldVarPrefix.setText(extractor.varPrefix)
      fieldFormName.setText(extractor.formName) 
    }
  }

  override def getLabelResource = RESOURCE_LABEL

  override def getStaticLabel = STATIC_LABEL

  private def makeParameterPanel = {
    val panel = new JPanel(new GridBagLayout)
    val gbc = new GridBagConstraints
    
    initConstraints(gbc)
    addField(panel, fieldFormName, gbc)
    resetContraints(gbc)
    addField(panel, fieldVarPrefix, gbc)
    resetContraints(gbc)
    gbc.weighty = 1
    panel
  }

}