import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StopwatchApplet extends Applet implements Runnable, ActionListener {
    private Thread thread;
    private boolean running;
    
    private long startTime;
    private long elapsedTime;
    private long pausedTime;
    
    private Button startButton;
    private Button stopButton;
    private Button resetButton;
    private Button lapButton;
    
    private ArrayList<Long> lapTimes;
    private Font displayFont;
    private Font lapFont;
    
    public void init() {
        // Initialize UI components
        setLayout(new BorderLayout());
        
        // Create font for display
        displayFont = new Font("Monospace", Font.BOLD, 24);
        lapFont = new Font("Monospace", Font.PLAIN, 12);
        
        // Create panel for buttons
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());
        
        // Create buttons
        startButton = new Button("Start");
        stopButton = new Button("Stop");
        resetButton = new Button("Reset");
        lapButton = new Button("Lap");
        
        // Add action listeners
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
        resetButton.addActionListener(this);
        lapButton.addActionListener(this);
        
        // Add buttons to panel
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(lapButton);
        
        // Add panel to applet
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Initialize variables
        running = false;
        startTime = 0;
        elapsedTime = 0;
        pausedTime = 0;
        lapTimes = new ArrayList<Long>();
        
        // Set initial button states
        stopButton.setEnabled(false);
        lapButton.setEnabled(false);
    }
    
    public void start() {
        // Start the applet
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
    
    public void stop() {
        // Stop the applet
        thread = null;
    }
    
    public void run() {
        // Main thread loop
        while (thread != null) {
            repaint();
            try {
                Thread.sleep(10); // Update every 10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void paint(Graphics g) {
        // Calculate current time
        long currentTime = 0;
        if (running) {
            currentTime = System.currentTimeMillis() - startTime + pausedTime;
        } else {
            currentTime = pausedTime;
        }
        
        // Format time as HH:MM:SS.ms
        String timeString = formatTime(currentTime);
        
        // Clear background
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // Draw time
        g.setColor(Color.black);
        g.setFont(displayFont);
        FontMetrics fm = g.getFontMetrics();
        int timeWidth = fm.stringWidth(timeString);
        g.drawString(timeString, (getWidth() - timeWidth) / 2, 50);
        
        // Draw lap times
        g.setFont(lapFont);
        int y = 80;
        for (int i = 0; i < lapTimes.size(); i++) {
            String lapString = "Lap " + (i + 1) + ": " + formatTime(lapTimes.get(i));
            g.drawString(lapString, 10, y);
            y += 20;
        }
    }
    
    private String formatTime(long time) {
        long ms = time % 1000;
        long totalSeconds = time / 1000;
        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds / 60) % 60;
        long hours = totalSeconds / 3600;
        
        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, ms);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // Start the stopwatch
            running = true;
            startTime = System.currentTimeMillis();
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            lapButton.setEnabled(true);
            resetButton.setEnabled(false);
        } else if (e.getSource() == stopButton) {
            // Stop the stopwatch
            running = false;
            pausedTime = System.currentTimeMillis() - startTime + pausedTime;
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            resetButton.setEnabled(true);
        } else if (e.getSource() == resetButton) {
            // Reset the stopwatch
            pausedTime = 0;
            lapTimes.clear();
            repaint();
        } else if (e.getSource() == lapButton) {
            // Record a lap time
            long currentTime = System.currentTimeMillis() - startTime + pausedTime;
            lapTimes.add(currentTime);
        }
    }
}