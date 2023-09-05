package code.src.codes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NQueenGrid {

    public List<Integer> publicList = new ArrayList<>(); 
    public int numberOfQueenGrid;
    public int gridSizeValue;

    public NQueenGrid(List<Integer> solutionList, int numberOfQueen, int gridSize) {
        publicList = solutionList;
        numberOfQueenGrid = numberOfQueen;
        gridSizeValue = gridSize;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private int columnCount = numberOfQueenGrid;
        private int rowCount = numberOfQueenGrid;
        private List<Rectangle> cells;
        private Point selectedCell;

        public TestPane() {
            int xOffset = 0;
            int yOffset = 0;
            cells = new ArrayList<>(columnCount * rowCount);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(gridSizeValue, gridSizeValue);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int width = getWidth();
            int height = getHeight();


            int cellWidth = width / columnCount;
            int cellHeight = height / rowCount;

            int xOffset = (width - (columnCount * cellWidth)) / 2;
            int yOffset = (height - (rowCount * cellHeight)) / 2;

            if (cells.isEmpty()) {
                for (int row = 0; row < rowCount; row++) {
                    for (int col = 0; col < columnCount; col++) {
                        Rectangle cell = new Rectangle(
                                xOffset + (col * cellWidth),
                                yOffset + (row * cellHeight),
                                cellWidth,
                                cellHeight);
                        cells.add(cell);
                    }
                }
            }
            for (Integer index : publicList) {
                Rectangle cell = cells.get(index);
                g2d.setColor(Color.black);
                g2d.fill(cell);
            }

            g2d.setColor(Color.GRAY);
            for (Rectangle cell : cells) {
                g2d.draw(cell);
            }
            g2d.dispose();
        }
    }
}
