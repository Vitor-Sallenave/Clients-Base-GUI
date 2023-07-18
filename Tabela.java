// Classes para construcao da interface
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;


public class Tabela extends JFrame {
	// Elementos graficos
    private JPanel painelFundo;
    private JTable table;
    private JScrollPane barraRolagem;
	
	// Colunas de PessoaIMC
    private static String[] colPessoas = {"Nome", "Data de Nascimento",
	"Peso (kg)", "Altura (m)", "Genero", "Idade", "IMC", "Faixa - IMC"};
	
	// Linhas de PessoaIMC
	private String[][] linPessoas;
	
	// Definindo os dados que irao compor a tabela
	public void setDados(ArrayList<PessoaIMC> lista){
		this.linPessoas = new String[lista.size()][8];
		
		for (int i = 0; i < lista.size(); i++){
			this.linPessoas[i] = lista.get(i).getDados();
		}
	}

	// Criando a janela
    public void criaJanela(){
		// Criando o painel
        this.painelFundo = new JPanel();
        this.painelFundo.setLayout(new GridLayout(1, 1));
		
		// Criando a tabela
        table = new JTable(this.linPessoas, colPessoas);
		
		// Adicionando a barra de rolagem ao painel
        barraRolagem = new JScrollPane(this.table);
        painelFundo.add(barraRolagem);
		
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Tamanho e visibilidade da janela
        setSize(500, 120);
        setVisible(true);
    }
}