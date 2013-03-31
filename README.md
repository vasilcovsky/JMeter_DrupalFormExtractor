JMeter Drupal Form Extractor Plugin
===================================

JMeter plugin for extracting Drupal form values for fields form_id, form_build_id, form_token for further requests.

Installation
------------

1.   Compile
	> sbt package-bin

2.   Copy generated package to *JMETER_HOME/lib/ext*
3.   Copy scala-library.jar to *JMETER_HOME/lib*

Usage
-----

The Drupal Form Extractor allows the user to extract hidden Drupal form fields: form_id, form_build_id, form_token from a server response. As a post-processor, this element will execute after each Sample request in its scope, extracting values as into variables:
-   FORM_ID
-   FORM_BUILD_ID
-   FORM_TOKEN

**Control Panel**
https://raw.github.com/vasilcovsky/JMeter_DrupalFormExtractor/master/media/jmeter-drupal-form-extractor.png


<table>
  <tr>
    <th>Attribute</th>
	<th>Description</th>
	<th>Required</th>
  </tr>
  <tr>
	<td>Name</td>
	<td>Descriptive name for this element that is shown in the tree.</td>
	<td>No</td>
  </tr>
  <tr>
	<td>Form ID</td>
	<td>The ID of tag <form> which contains required fields. This value is required if several forms exist on the page.</td>
	<td>If page contains more two or more forms.</td>
  </tr>
  <tr>
	<td>Variable Prefix</td>
	<td>Unique prefix for variables: *FORM_ID*, *FORM_BUILD_ID*, *FORM_TOKEN*. Variable with prefix looks like *PREFIX*_FORM_ID.</td>
	<td>No</td>
  </tr>
</table>