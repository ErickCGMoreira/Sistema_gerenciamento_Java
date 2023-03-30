/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframes;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import model.Atendimento;
import model.Cliente;
import model.Funcionario;
import model.modell;

/**
 *
 * @author erick
 */
class ButtonEditorUp extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;
  
  private HashMap<String,Atendimento> atendimentos = new HashMap<>();
    private HashMap<String,Cliente> clientes = new HashMap<>();
    private HashMap<String,Funcionario> funcionarios = new HashMap<>();
    
    private int tipo;


  public ButtonEditorUp(JCheckBox checkBox,int tipo, HashMap<String,Atendimento> atendimentos, HashMap<String,Cliente> clientes, HashMap<String,Funcionario> funcionarios) {
    super(checkBox);
    this.atendimentos = atendimentos;
    this.clientes = clientes;
    this.funcionarios = funcionarios;
    this.tipo = tipo;
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText("Alterar");
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
      // 
      // 
      //JOptionPane.showMessageDialog(button, label + ": Ou!");
      // System.out.println(label + ": Ouch!");
      switch (tipo){
          case 1:
                AlterarFuncinario alter1 = new AlterarFuncinario(funcionarios.get(label), false);
                alter1.setVisible(true);
                break;
            case 2:
                AlterarAtendimento alter2 = new AlterarAtendimento(atendimentos.get(label), false);
                alter2.setVisible(true);
                break;
            case 3:
                AlterarCliente alter3 = new AlterarCliente(clientes.get(label), false);
                alter3.setVisible(true);
                break;
      }
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}
