/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframes;

import dao.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Atendimento;
import model.Cliente;
import model.Funcionario;

/**
 *
 * @author erick
 */
class ButtonEditorOS extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;
  
  private HashMap<String,Atendimento> atendimentos = new HashMap<>();
  private HashMap<String,Cliente> clientes = new HashMap<>();
  private HashMap<String,Funcionario> funcionarios = new HashMap<>();

  public ButtonEditorOS(JCheckBox checkBox, HashMap<String,Atendimento> atendimentos, HashMap<String,Cliente> clientes, HashMap<String,Funcionario> funcionarios) {
    super(checkBox);
    this.atendimentos = atendimentos;
    this.clientes = clientes;
    this.funcionarios = funcionarios;
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
    button.setText("Deletar");
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
      // 
      // 
//      JOptionPane.showMessageDialog(button, label + ": Ou!");
      // System.out.println(label + ": Ouch!");
      Atendimento x = atendimentos.get(label);
      OrdemDeServico.salvar(x, clientes.get(x.getIdCliente()+""), funcionarios.get(x.getIdFuncionario()+""));
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