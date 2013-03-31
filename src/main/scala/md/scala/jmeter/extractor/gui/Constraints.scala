package md.scala.jmeter.extractor.gui

import java.awt.{GridBagConstraints, GridBagLayout}
import javax.swing.{JPanel}
import org.apache.jorphan.gui.{JLabeledTextField}

trait Constraints {

  def addField(panel: JPanel, field: JLabeledTextField, gbc: GridBagConstraints) {
    val items = field.getComponentList
    panel.add(items.get(0), gbc.clone)
    gbc.gridx += 1
    gbc.weightx = 1
    gbc.fill = GridBagConstraints.HORIZONTAL
    panel.add(items.get(1), gbc.clone)
  }

  def resetContraints(gbc: GridBagConstraints) {
    gbc.gridx = 0
    gbc.gridy += 1
    gbc.weightx = 0
    gbc.fill = GridBagConstraints.NONE
  }

  def initConstraints(gbc: GridBagConstraints) {
    gbc.anchor = GridBagConstraints.NORTHWEST
    gbc.fill = GridBagConstraints.NONE
    gbc.gridheight = 1
    gbc.gridwidth = 1
    gbc.gridx = 0
    gbc.gridy = 0
    gbc.weightx = 0
    gbc.weighty = 0
   }

}