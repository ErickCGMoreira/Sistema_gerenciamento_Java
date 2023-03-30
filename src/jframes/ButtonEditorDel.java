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
class ButtonEditorDel extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;
  
  private int tipo;
  
  private HashMap<String,Atendimento> atendimentos = new HashMap<>();
    private HashMap<String,Cliente> clientes = new HashMap<>();
    private HashMap<String,Funcionario> funcionarios = new HashMap<>();

  public ButtonEditorDel(JCheckBox checkBox, int tipo, HashMap<String,Atendimento> atendimentos, HashMap<String,Cliente> clientes, HashMap<String,Funcionario> funcionarios) {
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
      switch(tipo){
          case 1:
              int result = JOptionPane.showConfirmDialog(null, "Tem certesa que quer deletar? Essa ação não poderá ser desfeita!");

                if (result == 0){
                    System.out.println("Excluido");
                    FuncionarioDAO.excluir(funcionarios.get(label));
                }else{
                    System.out.println("Não foi excluido");
                }
                break;
            case 2:
                int result1 = JOptionPane.showConfirmDialog(null, "Tem certesa que quer deletar? Essa ação não poderá ser desfeita!");

                if (result1 == 0){
                    System.out.println("Excluido");
                    AtendimentoDAO.excluir(atendimentos.get(label));
                }else{
                    System.out.println("Não foi excluido");
                }
                break;
            case 3:
                int result2 = JOptionPane.showConfirmDialog(null, "Tem certesa que quer deletar? Essa ação não poderá ser desfeita!");

                if (result2 == 0){
                    System.out.println("Excluido");
                    ClienteDAO.excluir(clientes.get(label));
                }else{
                    System.out.println("Não foi excluido");
                }
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