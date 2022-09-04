/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivosejemplo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Principal extends javax.swing.JFrame {
    // Variables globales de archivo, de los datos que este tiene dentro y el
    // archivo como tal

    String pathFile = "";
    String lectura = "";
    File f;

    public Principal() {
        initComponents();
        btnUsuarios.setVisible(false);
    }

    public void mostrarDatos() {
        lectura = "";
        try {
            // FileReader abre el flujo de lectura de datos del archivo
            FileReader lectorArchivo = new FileReader(f);
            BufferedReader br = new BufferedReader(lectorArchivo);
            // leer los datos que tiene el archivo
            String aux = "";// acumular los datos del archivo
            while (true) {// mientras que cada linea del achivo tenga COTENIDO haga lo que tenga el while
                // En cada iteracion lee una linea y se guarda en aux
                aux = br.readLine();
                if (aux != null) {
                    // se guardad esas lineas en lectura
                    lectura = lectura + aux + "\n";
                } else {
                    // Al llegar a una linea y no detectar nada lo que hace es cortar el flujo de
                    // iteracion
                    break;
                }
            }
            br.close();
            lectorArchivo.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public String solicitudDatos() {
        String datosPersona = "";
        // declarar las variables
        int numAfiliados;
        // char -> (uno) caracteres
        // Arreglos(vector) - tipo_de_dato nombre_Vector[]
        String arrayStringAfiliado[][];
        // Arreglo (Matriz) - tipo_de_dato nombre_matriz[][]
        double datosAfiliacion[][];
        String tipoAfiliacion[][];
        try {
            // Pide un numero de personas que se va a hacer registro
            numAfiliados = Integer.parseInt(JOptionPane.showInputDialog(
                    "Por favor ingrese el numero de Personas a registrar"));
            // Lugar donde se guarda el nombre la edad e identificacion
            arrayStringAfiliado = new String[numAfiliados][2];
            // Guarda edad de la persona
            datosAfiliacion = new double[numAfiliados][1];
            // Guarda el tipo de afiliacion que tiene el usuario
            tipoAfiliacion = new String[numAfiliados][1];
            // Se hace un for para que itere las veces que nosotros le dijimos que hibamos a
            // ingresar de usuarios
            // Con eso se termine hasta que i llegue a un valor igual a numAfiliados
            for (int i = 0; i < numAfiliados; i++) {
                // pide datos del nombre
                arrayStringAfiliado[i][0] = JOptionPane.showInputDialog(
                        "Por favor ingrese su nombre");
                // pide datos de la edad
                datosAfiliacion[i][0] = Integer.valueOf(JOptionPane.showInputDialog(
                        "Por favor ingrese la edad del estudiante"));
                // pide datos de la estudiante
                arrayStringAfiliado[i][1] = (JOptionPane.showInputDialog(
                        "Por favor ingrese la identificacion del estudiante"));
                // pide datos del tipo de afiliacion
                tipoAfiliacion[i][0] = JOptionPane.showInputDialog(
                        "Por favor ingrese el tipo de afiliacion: (a, b, c, ninguna)");

                // Condiciones de tipo de usuario
                // Si el usuario es menor de edad
                if (datosAfiliacion[i][0] <= 18) {
                    int valor_a_pagar = 5000;
                    datosPersona = datosPersona + arrayStringAfiliado[i] + "\t"
                            + datosAfiliacion[i][0] + "\t" + arrayStringAfiliado[i][1] + "\t" + valor_a_pagar + "\t" +
                            tipoAfiliacion[i][0]
                            + "\n";
                } else {
                    // Si el usuario es mayor de edad y su tipo de afiliacion es ninguna
                    if (tipoAfiliacion[i][0].equals("ninguna") && datosAfiliacion[i][0] > 18) {
                        int valor_a_pagar = 30000;
                        datosPersona = datosPersona + arrayStringAfiliado[i] + "\t"
                                + datosAfiliacion[i][0] + "\t" + arrayStringAfiliado[i][1] + "\t" + valor_a_pagar + "\t"
                                +
                                tipoAfiliacion[i][0]
                                + "\n";

                    }
                    // Si su tipo de afiliacion es a y es mayor de edad
                    else if (tipoAfiliacion[i][0].equals("a") && datosAfiliacion[i][0] > 18) {
                        int valor_a_pagar = 30000 - ((30000 * 15) / 100);
                        datosPersona = datosPersona + arrayStringAfiliado[i] + "\t"
                                + datosAfiliacion[i][0] + "\t" + arrayStringAfiliado[i][1] + "\t" + valor_a_pagar + "\t"
                                +
                                tipoAfiliacion[i][0]
                                + "\n";
                    } else
                    // Si su tipo de afiliacion es b y es mayor de edad
                    if (tipoAfiliacion[i][0].equals("b") && datosAfiliacion[i][0] > 18) {
                        int valor_a_pagar = 30000 - ((30000 * 30) / 100);
                        datosPersona = datosPersona + arrayStringAfiliado[i] + "\t"
                                + datosAfiliacion[i][0] + "\t" + arrayStringAfiliado[i][1] + "\t" + valor_a_pagar + "\t"
                                +
                                tipoAfiliacion[i][0]
                                + "\n";
                    } else

                    // Si su tipo de afiliacion es c y es mayor de edad
                    if (tipoAfiliacion[i][0].equals("c") && datosAfiliacion[i][0] > 18) {
                        int valor_a_pagar = 30000 - ((30000 * 50) / 100);
                        datosPersona = datosPersona + arrayStringAfiliado[i] + "\t"
                                + datosAfiliacion[i][0] + "\t" + arrayStringAfiliado[i][1] + "\t" + valor_a_pagar + "\t"
                                +
                                tipoAfiliacion[i][0]
                                + "\n";
                    }
                }
            }
        }
        // Si hay un error que me muestre en consola el error
        catch (

        Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        // Retorno de los datos
        return datosPersona;
    }

    // Guardar los datos en el archivo
    public void concatenar(String texto_solicitud_Datos) {
        FileWriter escritorArchivo;
        try {
            // Crear el flujo para agregar los datos al archivo
            // sobrescribir l que tiene el archivo + nuevo
            String temporal = lectura + texto_solicitud_Datos;
            escritorArchivo = new FileWriter(f);// ruta del archivo
            BufferedWriter bw = new BufferedWriter(escritorArchivo);
            // escribir dentro del archivo
            PrintWriter salida = new PrintWriter(bw);
            salida.write(temporal);
            JOptionPane.showMessageDialog(rootPane, "datos registrados");
            salida.close();
            bw.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtADatos = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 73, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenidos a nuestro Programa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)
                                .addContainerGap(35, Short.MAX_VALUE)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtADatos.setColumns(20);
        txtADatos.setRows(5);
        jScrollPane1.setViewportView(txtADatos);

        btnBuscar.setBackground(new java.awt.Color(100, 100, 100));
        btnBuscar.setText("Buscar Archivo");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(100, 100, 100));
        btnUsuarios.setText("Crear Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 38,
                                                Short.MAX_VALUE)
                                        .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        // Crearel objeto de FileChooser
        JFileChooser jf = new JFileChooser();
        // Abirir la ventana
        jf.showOpenDialog(jPanel1);
        try {
            // capturando la ruta
            pathFile = jf.getSelectedFile().getAbsolutePath();
            f = new File(pathFile);
            mostrarDatos();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        txtADatos.setText(lectura);
        btnUsuarios.setVisible(true);
    }// GEN-LAST:event_btnBuscarActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        try {
            concatenar(solicitudDatos());
            mostrarDatos();
            txtADatos.setText(lectura);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }// GEN-LAST:event_btnUsuariosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtADatos;
    // End of variables declaration//GEN-END:variables
}
