
import java.awt.FlowLayout; 
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Parser
 
 
{
 
    private int currentIndex;
    private String[] data;
    JFrame window = null;
 
 
    public Parser()
 
    {
        init();
 
    }
 
    public static void main(String[] args) 
 
    {
    	Parser Parser = new Parser();
    }
 
  private String getGrammer() throws IOException

    {
 
        BufferedReader reader = new BufferedReader(new FileReader("Calculator.txt"));
 
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
 
        while ((line = reader.readLine()) != null) 
 
        {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
 
        return stringBuilder.toString();
 
 
    }
 
 
    private void init() 
 
    {
        try 
        {
            String grammer = getGrammer();

            data = grammer.split("\\n");
            ArrayList<String> tokensList = getTokens(data[0]);
 
            String component = tokensList.get(0);
  
 
            if (component.equalsIgnoreCase("Window"))
            {
                try 
                {

                    String title = tokensList.get(1).replace("\"", ""); 
                    int width = Integer.parseInt(tokensList.get(2).substring(1, tokensList.get(2).length() - 1));
 
                    int height = Integer.parseInt(tokensList.get(3).substring(0, tokensList.get(3).length() - 1));
 
                    LayoutManager layout = null;
 
                    if (tokensList.size() > 4) 
 
                    {
 

                        if (tokensList.get(4).equalsIgnoreCase("Layout")) 
 
                        {
                            layout = getLayout(tokensList.subList(5, tokensList.size()));
                        } 
 
                        else 
 
                        {
                            throw new Exception("Syntax error");
                        }
 
                    }
 
                    window = (createWindow(title, width, height, layout));
 
                    System.out.println(title + ", " + width + ", " + height);
 
                } 
 
                catch (Exception e)
 
                {
                    e.printStackTrace();
                    throw new Exception("Syntax error");
                }
 
 
            }
 
            else 
 
            {
                throw new Exception("No GUI found for this input");
            }
 
 

 
            for (currentIndex = 1; currentIndex < data.length; currentIndex++)
 
            {
                tokensList.clear();
                tokensList = getTokens(data[currentIndex]);
 
                if (tokensList.get(0).equalsIgnoreCase("Button"))
 
                {
                    window.add(new JButton(getComponetLabel(tokensList.get(1))));
                } 
 
                else if (tokensList.get(0).equalsIgnoreCase("Label"))
 
                {
                    window.add(new JLabel(getComponetLabel(tokensList.get(1))));
                } 
 

 
                else if (tokensList.get(0).equalsIgnoreCase("Textfield"))
 
                {
                    String token = tokensList.get(1);
                    token = token.substring(0, token.length() - 1);
                    window.add(new JTextField(Integer.parseInt(token)));
                } 
 
                window.validate();
            }
 
 
        } 
 
        catch (Exception e)
 
        {
            e.printStackTrace();
        }
 
    }
 
 
    private JPanel getPanel() throws Exception 
    {
        JPanel panel = new JPanel();
        ArrayList<String> tokensList = getTokens(data[currentIndex]);
 
        if (tokensList.get(1).equalsIgnoreCase("Layout"))
 
        {
            panel.setLayout(getLayout(tokensList.subList(2, tokensList.size())));
        } 
 
        else 
 
        {
            throw new Exception("invalid Layout syntax at row " + currentIndex);
        }
 
 
        for (currentIndex = currentIndex + 1; currentIndex < data.length; currentIndex++) 
 
        {
            tokensList.clear();
            tokensList = getTokens(data[currentIndex]);
 
            if (tokensList.get(0).equalsIgnoreCase("Button"))  
 
            {
                panel.add(new JButton(getComponetLabel(tokensList.get(1)))); 
            } 
 
            else if (tokensList.get(0).equalsIgnoreCase("Label"))  
 
            {
                panel.add(new JLabel(getComponetLabel(tokensList.get(1))));
            } 
 
            else if (tokensList.get(0).equalsIgnoreCase("Textfield")) 
 
            {
                String token = tokensList.get(1);
                token = token.substring(0, token.length() - 1);
                panel.add(new JTextField(Integer.parseInt(token)));
            } 
 
            else if (tokensList.get(0).equalsIgnoreCase("Panel"))
 
            {
                panel.add(getPanel());
            }
 
            else if (tokensList.get(0).equalsIgnoreCase("End;"))  
 
            {
                return panel;
            }
 
        }
 
        throw new Exception("No End tag forund");
    }
 
    private String getComponetLabel(String token)
 
    {
        if (token.length() > 3) 
 
        {
            return token.substring(1, token.length() - 2);
        }
 
        else 
 
        {
            return "";
        }
    }
 
   
    private LayoutManager getLayout(java.util.List<String> layoutTokensList) throws Exception
 
    {
        if (layoutTokensList.get(0).equalsIgnoreCase("Flow:")) 
 
        {
            return new FlowLayout();
 
        } 
 
        else if (layoutTokensList.get(0).equalsIgnoreCase("Grid"))
 
        {
            int parm1 = Integer.parseInt(layoutTokensList.get(1).substring(1, layoutTokensList.get(1).length() - 1));
            int parm2 = Integer.parseInt(layoutTokensList.get(2).substring(0, layoutTokensList.get(2).length() - 1));
            int parm3 = Integer.parseInt(layoutTokensList.get(3).substring(0, layoutTokensList.get(3).length() - 1));
            int parm4 = Integer.parseInt(layoutTokensList.get(4).substring(0, layoutTokensList.get(4).length() - 2));
            System.out.println(parm1 + ", " + parm2 + ", " + parm3 + ", " + parm4);
 
            return new GridLayout(parm1, parm2, parm3, parm4);
        } 
 
        else 
 
        {
            throw new Exception("Invalid Layout");
        }
    }
 
    private JFrame createWindow(String title, int width, int height, LayoutManager layout) 
 
    {
        JFrame frame = new JFrame(title);
 
        if (layout != null) 
 
        {
            frame.setLayout(layout);
        }
 
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
 
    }
 
    private ArrayList<String> getTokens(String grammer) 
 
    {
 
        String[] tokens = grammer.trim().split(" ");
        ArrayList<String> tokensList = new ArrayList<String>();
 
 
        for (int i = 0; i < tokens.length; i++)
 
        {
            String token = tokens[i].trim();
            if (token.equals(" ") || token.equals(""))
 
            {
                continue;
            }
            tokensList.add(token);
            System.out.println(token);
        }
 
        return tokensList;
    }
}
 