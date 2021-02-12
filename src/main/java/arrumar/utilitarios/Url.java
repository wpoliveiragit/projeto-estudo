package arrumar.utilitarios;

import java.io.File;

/**
 * Controle de caminhos de arquivos.
 * 
 * @author Wellington Pires de Olieira
 */
public class Url {

	/**
	 * Retorna a url do arquivo.
	 * 
	 * @param nomeArquivo o nome do arquivo.
	 * @return A url do arquivo ou null se e somente se o arquivo nao existir dentro
	 *         do projeto.
	 */
	public static final String getURL(String nomeArquivo) {
		return procuraArq(new File(new File("").getAbsolutePath()), nomeArquivo);

	}

	/**
	 * Busca o arquivo dentro do caminho do parametro, caso encontre, salvara a url
	 * na variavel estatica url
	 * 
	 * @param path        o caminho a ser verificado.
	 * @param nomeArquivo o nome do arquivo.
	 * @return true se e somente se encontrar o arquivo.
	 */
	private static String procuraArq(File path, String nomeArquivo) {
		if (path.isDirectory()) {
			String[] listaItens = path.list();
			String url;
			for (String item : listaItens) {
				url = procuraArq(new File(path, item), nomeArquivo);
				if (url != null) {
					return url;
				}
			}
		}
		return path.getName().equalsIgnoreCase(nomeArquivo) ? path.getAbsolutePath() : null;
	}

	public static void main(String[] args) {
		String s = getURL("fantasma01.png");
		System.out.println(s);
	}

}
