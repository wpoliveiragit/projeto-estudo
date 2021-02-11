package arrumar.arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Nesta classe será abordado os métodos mais importantes para manipulação de
 * arquivos e pastas, aprenderemos a criar arquivos e pastas, deletar arquivos e
 * pastas e manipular arquivos.
 * 
 * CONCIDERAÇÕES NECESSARIAS
 * 
 * 01- A classe File 'apenas' cria um objeto que guardará um caminho de um
 * arquivo ou pasta (estando esse endereço correto ou não ele irá aceitar).
 *
 * 02- Para colocar o caracter '\' em uma string, precisamos colocar ele duas
 * vezes, ex este caminho "C:\\diretorio\arquivo.txt" ficaria assim
 * "C:\\\\diretorio\\arquivo.txt";
 *
 * 03- Existem duas maneiras para informar um caminho, passando o caminho
 * completo (caminho absoluto) ou parte dele (caminho corrente):
 * 
 * O 'caminho absoluto' consiste em informar desde a raiz o endereço, ex:
 * "c:\\\\diretorio\\subdiretorio\\arquivo.txt";
 * 
 * O 'caminho corrente' consiste em assumir que o caminho raiz é o diretório
 * onde o projeto ou programa se encontra, ex de caminho corrente:
 * "diretorio\\arquivo.txt", o caminho faltante será adicionado antes do caminho
 * corrente.
 * 
 * Obs.: Esta classe tem apenas a finalidade didática
 *
 * @author Wellington Pires de Oliveira.
 * @date 23/04/2018.
 */
public class Arquivo {

	public static void main(String[] args) {
		String raiz = "";
		String pasta = "pasta";
		String subPasta = "subPasta";
		String arquivo = "arquivo.txt";
		// criaremos um objeto file de caminho corrente
		File f = new File(raiz + pasta);
		// getPath() retorna o caminho informado na criação do arquivo
		System.out.println("Caminho: " + f.getPath());
		// getPath() retorna o caminho desde a raiz
		System.out.println("Caminho absoluto: " + f.getAbsolutePath());
		// Vamos criar a pasta
		if (!f.mkdir() && !f.exists()) {
			System.out.println("Problemas ao criar a pasta '" + f.getPath() + "'");
			System.out.println("O programa foi finalizado prematuramente");
			System.exit(-1);
		}
		System.out.println("A pasta '" + pasta + "' foi criada");
		// Vamos criar uma sub pasta
		f = new File(f.getPath(), subPasta);
		if (!f.mkdir() && !f.exists()) {
			System.out.println("Problemas ao criar a pasta '" + f.getPath() + "'");
			System.out.println("O programa foi finalizado prematuramente");
			System.exit(-1);
		}
		System.out.println("A sub pasta '" + subPasta + "' foi criada");
		// Vamos criar um arquivo dentro dessa sub pasta
		f = new File(f.getPath(), arquivo);
		try {
			if (!f.createNewFile() && !f.exists()) {
				System.out.println("Problemas ao criar a pasta '" + f.getPath() + "'");
				System.out.println("O programa foi finalizado prematuramente");
				System.exit(-1);
			}
			System.out.println("O arquivo '" + arquivo + "' foi criado");
		} catch (IOException ex) {
			System.out.println("Erro ao estabilizar a conexão do arquivo '" + arquivo + "'");
			System.exit(-1);
		}

		// Vamos escrever neste arquivo
		try {
			/**
			 * Sempre que um objeto FileWriter (gravador byte-a-byte) é criado, uma
			 * verificação de existencia será feito, se ele não existir será criado
			 * automaticamente. O parametro applend como true idicará que ao solicitar a
			 * escrita, o texto adicionado ao final do arquivo, mas como false sempre que
			 * for solicitado a escrita, o arquivo será recriado em branco para adicionar o
			 * novo texto.
			 * 
			 * Obs.: A classe PrintWriter não consegue alterar textos em arquivo, sendo
			 * assim, devemos ler todo o arquivo, trabalhar com ele em memoria e gravar com
			 * o applend em false.
			 */
			// Vamos criar o canal de leitura
			FileWriter fw = new FileWriter(f, true);
			// criamos um streaming para gravar o texto como char e não como bite ASCII.
			PrintWriter registrador = new PrintWriter(fw);
			// gravando no arquivo
			registrador.println("Linha 01");
			registrador.println("Linha 02");
			registrador.println("Linha 03");
			registrador.flush();// Devemos sempre após o uso limpar a porta de saida
			registrador.close();// sempre feche o canal para liberar memória
			System.out.println("Gravação no arquivo efetuada");
		} catch (IOException ex) {
			System.out.println("Problemas na escrita do arquivo '" + f.getPath() + "'");
			System.out.println("O programa foi finalizado prematuramente");
			System.exit(-1);
		}

		// Vamos recuperar o texto deste arquivo
		try {
			// Criamos um fluxo de entrada byte-a-bytede neste arquivo
			FileInputStream fis = new FileInputStream(f);
			// Criamos um conversor de bytes para char
			InputStreamReader isr = new InputStreamReader(fis);
			// Criamos um buffer para as leitura para aumentar a performance
			BufferedReader br = new BufferedReader(isr);
			String linha;
			String texto = "";
			// a leitura será feita linha a linha ('\n')
			while ((linha = br.readLine()) != null) {
				// as leituras removem o '\n' então vamos adicionar novamente
				texto += linha + "\n";
			}
			br.close();// sempre feche o canal para liberar memória
			System.out.println("\nTexto recuperado do arquivo '" + arquivo + "\n" + texto);
		} catch (FileNotFoundException ex) {
			System.out.println("Problemas na escrita do arquivo '" + f.getPath() + "'");
			System.out.println("O programa foi finalizado prematuramente");
			System.exit(-1);
		} catch (IOException ex) {

		}
		// Vamos excluir tudo o que criamos, então vamos criar um método 'delete'
		f = new File(pasta);
		delete(f);
		System.out.println("\n*** fim do programa ***");

	}

	/**
	 * Deleta uma pasta ou arquivo.
	 *
	 * @param path O caminho do que deseja deletar.
	 * @return true Em caso de sucesso.
	 */
	private static boolean delete(File f) {
		/**
		 * Só temos uma regra que devemos nos preocupar antes de excluir um caminho, "Ao
		 * excluir um diretório devemos garantir que ele esteja vazio".
		 */
		if (f.isDirectory()) {
			// obtemos uma lista de nomes dos itens contidos na pasta
			String[] listaItensPasta = f.list();
			// deletamos cada item da lista
			for (String itensPasta : listaItensPasta) {
				delete(new File(f, itensPasta));
			}
		}
		System.out.println("Deletado '" + f.getPath() + "'");
		return f.delete();
	}

}
