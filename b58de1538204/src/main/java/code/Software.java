
package code;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

class NodoCircularSimple {
    String codigoTurno, nombrePersona, documentoPersona;
    NodoCircularSimple siguiente;

    public NodoCircularSimple(String codigo, String nombre, String documento) {
        this.codigoTurno = codigo;
        this.nombrePersona = nombre;
        this.documentoPersona = documento;
    }
}

class ListaCircularSimple {
    private NodoCircularSimple ultimo;

    public boolean estaVacia() {
        return ultimo == null;
    }

    public void agregarTurno(String codigo, String nombre, String documento) {
        NodoCircularSimple nuevo = new NodoCircularSimple(codigo, nombre, documento);
        if (estaVacia()) {
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public NodoCircularSimple atenderTurno() {
        if (estaVacia()) return null;
        NodoCircularSimple primero = ultimo.siguiente;
        if (ultimo == primero) {
            ultimo = null;
        } else {
            ultimo.siguiente = primero.siguiente;
        }
        return primero;
    }

    public String listarTurnos() {
        if (estaVacia()) return "No hay turnos pendientes.";
        StringBuilder sb = new StringBuilder();
        NodoCircularSimple actual = ultimo.siguiente;
        do {
            sb.append("Código: ").append(actual.codigoTurno)
              .append(" | Nombre: ").append(actual.nombrePersona)
              .append(" | Documento: ").append(actual.documentoPersona).append("\n");
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
        return sb.toString();
    }
}

class NodoCircularDoble {
    String codigoTurno, nombrePersona, documentoPersona, operario;
    NodoCircularDoble siguiente;

    public NodoCircularDoble(String codigo, String nombre, String documento, String operario) {
        this.codigoTurno = codigo;
        this.nombrePersona = nombre;
        this.documentoPersona = documento;
        this.operario = operario;
    }
}

class ListaCircularDoble {
    private NodoCircularDoble ultimo;

    public void agregarHistorial(String codigo, String nombre, String documento, String operario) {
        NodoCircularDoble nuevo = new NodoCircularDoble(codigo, nombre, documento, operario);
        if (ultimo == null) {
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            NodoCircularDoble primero = ultimo.siguiente;
            nuevo.siguiente = primero;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public String listarHistorial() {
        if (ultimo == null) return "No hay turnos atendidos.";
        StringBuilder sb = new StringBuilder();
        NodoCircularDoble actual = ultimo.siguiente;
        do {
            sb.append("Código: ").append(actual.codigoTurno)
              .append(" | Nombre: ").append(actual.nombrePersona)
              .append(" | Documento: ").append(actual.documentoPersona)
              .append(" | Operario: ").append(actual.operario).append("\n");
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
        return sb.toString();
    }
}

public class Software extends JFrame {
    private final ListaCircularSimple turnos = new ListaCircularSimple();
    private final ListaCircularDoble historial = new ListaCircularDoble();
    private int contadorTurnos = 1;
    private int operarioIndex = 0;
    private final String[] operarios = {"Operario 1", "Operario 2", "Operario 3"};

    public Software() {
        setTitle("Control de Turnos - Universidad Compensar");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnNuevoTurno = new JButton("Solicitar Turno");
        JButton btnAtenderTurno = new JButton("Asignar Turno a Operario");
        JButton btnVerTurnos = new JButton("Ver Turnos Pendientes");
        JButton btnVerHistorial = new JButton("Ver Historial");
        JButton btnSalir = new JButton("Salir");

        add(btnNuevoTurno);
        add(btnAtenderTurno);
        add(btnVerTurnos);
        add(btnVerHistorial);
        add(btnSalir);

        // Eventos de botones
        btnNuevoTurno.addActionListener(e -> solicitarTurno());
        btnAtenderTurno.addActionListener(e -> asignarTurno());
        btnVerTurnos.addActionListener(e -> mostrarTurnos());
        btnVerHistorial.addActionListener(e -> mostrarHistorial());
        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void solicitarTurno() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre:");
        String doc = JOptionPane.showInputDialog(this, "Ingrese el documento:");
        if (nombre != null && doc != null && !nombre.isEmpty() && !doc.isEmpty()) {
            String codigo = "TUR" + contadorTurnos++;
            turnos.agregarTurno(codigo, nombre, doc);
            JOptionPane.showMessageDialog(this, "Turno generado: " + codigo);
        } else {
            JOptionPane.showMessageDialog(this, "Datos incompletos.");
        }
    }

    private void asignarTurno() {
        NodoCircularSimple turno = turnos.atenderTurno();
        if (turno == null) {
            JOptionPane.showMessageDialog(this, "No hay turnos por atender.");
            return;
        }

        String operario = operarios[operarioIndex];
        historial.agregarHistorial(turno.codigoTurno, turno.nombrePersona, turno.documentoPersona, operario);

        operarioIndex = (operarioIndex + 1) % operarios.length;

        JOptionPane.showMessageDialog(this,
                "Turno " + turno.codigoTurno + " asignado a " + operario);
    }

    private void mostrarTurnos() {
        String info = turnos.listarTurnos();
        JTextArea textArea = new JTextArea(info);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Turnos Pendientes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarHistorial() {
        String info = historial.listarHistorial();
        JTextArea textArea = new JTextArea(info);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Historial de Turnos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Software());
    }
}
