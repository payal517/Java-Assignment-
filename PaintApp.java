import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class PaintApp extends JFrame {
    // Current drawing settings
    private Color currentColor = Color.BLACK;
    private String currentShape = "Brush";
    private int brushSize = 10;

    // List to store the history of everything drawn
    private final ArrayList<DrawingPoint> points = new ArrayList<>();

    PaintApp() {
        setTitle("Simple Paint App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- TOP TOOLBAR: SHAPES & SIZES ---
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(230, 230, 230));

        String[] shapes = {"Brush", "Rectangle", "Oval", "Eraser"};
        for (String s : shapes) {
            JButton btn = new JButton(s);
            btn.addActionListener(e -> currentShape = s);
            topPanel.add(btn);
        }

        topPanel.add(new JLabel("  Size:"));
        Integer[] sizes = {5, 10, 20, 50};
        JComboBox<Integer> sizeBox = new JComboBox<>(sizes);
        sizeBox.setSelectedIndex(1); // Default to 10
        sizeBox.addActionListener(e -> brushSize = (int) sizeBox.getSelectedItem());
        topPanel.add(sizeBox);

        JButton clearBtn = new JButton("Clear All");
        clearBtn.addActionListener(e -> {
            points.clear();
            repaint();
        });
        topPanel.add(clearBtn);

        // --- BOTTOM TOOLBAR: COLORS ---
        JPanel colorPanel = new JPanel();
        colorPanel.setBorder(BorderFactory.createTitledBorder("Color Palette"));
        
        Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
        for (Color c : colors) {
            JButton cBtn = new JButton();
            cBtn.setBackground(c);
            cBtn.setPreferredSize(new Dimension(30, 30));
            cBtn.addActionListener(e -> {
                currentColor = c;
                // If they were erasing, switch back to brush automatically
                if (currentShape.equals("Eraser")) currentShape = "Brush";
            });
            colorPanel.add(cBtn);
        }

        // --- CENTER: DRAWING CANVAS ---
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                // Makes the drawing look smooth
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                for (DrawingPoint p : points) {
                    g2d.setColor(p.color);
                    if (p.type.equals("Rectangle")) {
                        g2d.fillRect(p.x - p.size/2, p.y - p.size/2, p.size, p.size);
                    } else {
                        // Brush, Oval, and Eraser all use circles
                        g2d.fillOval(p.x - p.size/2, p.y - p.size/2, p.size, p.size);
                    }
                }
            }
        };
        canvas.setBackground(Color.WHITE);

        // Mouse Listener for Drawing
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Color drawColor = currentShape.equals("Eraser") ? Color.WHITE : currentColor;
                points.add(new DrawingPoint(e.getX(), e.getY(), drawColor, currentShape, brushSize));
                canvas.repaint();
            }
        });

        // Assemble the frame
        add(topPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(colorPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Helper class to keep track of each "stamp" on the canvas
    static class DrawingPoint {
        int x, y, size;
        Color color;
        String type;

        DrawingPoint(int x, int y, Color c, String t, int s) {
            this.x = x; this.y = y; this.color = c; this.type = t; this.size = s;
        }
    }

    public static void main(String[] args) {
        // Run on the Event Dispatch Thread for thread-safety
        SwingUtilities.invokeLater(PaintApp::new);
    }
}