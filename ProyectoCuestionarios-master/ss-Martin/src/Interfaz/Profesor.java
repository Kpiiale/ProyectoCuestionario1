package Interfaz;

import Clases.ListaUsuarios;
import Clases.Usuario;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Profesor {
    public JPanel panel1;
    private JList list7;
    private JTextField txtUsuarioxd;
    private JTextField txtContrasenaXd;
    private JTextField txtCedulaxd;
    private JButton btnListarXD;
    private JButton btnPasarCurso1;
    private JButton btnPasarCurso2;
    private JButton btnPasarCurso3;
    private JTextArea textAreaCurso1;
    private JTextArea textAreaCurso2;
    private JTextArea textAreaCurso3;
    private JTextField txtTipoCurso;
    ListaUsuarios listaUsuarios = new ListaUsuarios();
    private void llenarJlist() {
        List<Usuario> listado = listaUsuarios.getUsuarios();
        DefaultListModel<Usuario> dlm = new DefaultListModel<>();
        for(Usuario j : listado){
            dlm.addElement(j); // Asegúrate de agregar objetos de tipo Usuario, no Strings.
        }
        list7.setModel(dlm);
    }

    public Profesor() {
        list7.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (list7.getSelectedIndex() != -1) {
                    int indice = list7.getSelectedIndex();
                    Usuario usuario = listaUsuarios.getUsuarios().get(indice);
                    txtUsuarioxd.setText(""+ usuario.getUsuario());
                    txtCedulaxd.setText(""+usuario.getCedula());
                    txtContrasenaXd.setText(""+usuario.getContrasena());
                    txtTipoCurso.setText(""+usuario.getTipo());
                }

            }
        });
        btnListarXD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarJlist();
            }
        });
        btnPasarCurso1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cedula =Integer.parseInt(txtCedulaxd.getText());
                String usuario=txtUsuarioxd.getText();
                String contrasena=txtContrasenaXd.getText();
                String curso = "CURSO1";
                Usuario usuarioNuevo = new Usuario(cedula,usuario,contrasena,curso);
                if (listaUsuarios.hayUsuariosRepetidos(listaUsuarios.usuarios,listaUsuarios.curso1)){
                    listaUsuarios.curso1.add(usuarioNuevo);
                    listaUsuarios.imprimirListaEnTextArea(listaUsuarios.curso1,textAreaCurso1);
                }else{
                    JOptionPane.showMessageDialog(null,"YA ESTA ESE USUARIO EN EN ESTE CURSO");
                    if (listaUsuarios.buscarUsuarioEnListas(usuarioNuevo,listaUsuarios.curso1,listaUsuarios.curso2,listaUsuarios.curso3)){
                        listaUsuarios.eliminarUsuarioEnListas(usuarioNuevo,listaUsuarios.curso1,listaUsuarios.curso2,listaUsuarios.curso3);
                    }
                }
            }
        });
        btnPasarCurso2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cedula =Integer.parseInt(txtCedulaxd.getText());
                String usuario=txtUsuarioxd.getText();
                String contrasena=txtContrasenaXd.getText();
                String curso = "CURSO2";
                Usuario usuarioNuevo = new Usuario(cedula,usuario,contrasena,curso);
                if (listaUsuarios.hayUsuariosRepetidos(listaUsuarios.usuarios,listaUsuarios.curso2)){
                    listaUsuarios.curso2.add(usuarioNuevo);
                    listaUsuarios.imprimirListaEnTextArea(listaUsuarios.curso2,textAreaCurso2);
                }else{
                    JOptionPane.showMessageDialog(null,"YA ESTA ESE USUARIO EN EN ESTE CURSO");
                    if (listaUsuarios.buscarUsuarioEnListas(usuarioNuevo,listaUsuarios.curso1,listaUsuarios.curso2,listaUsuarios.curso3)){
                        listaUsuarios.eliminarUsuarioEnListas(usuarioNuevo,listaUsuarios.curso1,listaUsuarios.curso2,listaUsuarios.curso3);
                    }
                }
            }
        });
        btnPasarCurso3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cedula =Integer.parseInt(txtCedulaxd.getText());
                String usuario=txtUsuarioxd.getText();
                String contrasena=txtContrasenaXd.getText();
                String curso = "CURSO3";
                Usuario usuarioNuevo = new Usuario(cedula,usuario,contrasena,curso);
                if (listaUsuarios.hayUsuariosRepetidos(listaUsuarios.usuarios,listaUsuarios.curso3)){
                    listaUsuarios.curso3.add(usuarioNuevo);
                    listaUsuarios.imprimirListaEnTextArea(listaUsuarios.curso3,textAreaCurso3);
                }else{
                    JOptionPane.showMessageDialog(null,"YA ESTA ESE USUARIO EN EN ESTE CURSO");
                    if (listaUsuarios.buscarUsuarioEnListas(usuarioNuevo,listaUsuarios.curso1,listaUsuarios.curso2,listaUsuarios.curso3)){
                        listaUsuarios.eliminarUsuarioEnListas(usuarioNuevo,listaUsuarios.curso1,listaUsuarios.curso2,listaUsuarios.curso3);
                    }
                }

            }
        });
    }
}
