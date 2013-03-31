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

The Drupal From Extractor allows the user to extract hidden Drupal form fields: form_id, form_build_id, form_token from a server response. As a post-processor, this element will execute after each Sample request in its scope, extracting values as into variables:
-   FORM_ID
-   FORM_BUILD_ID
-   FORM_TOKEN