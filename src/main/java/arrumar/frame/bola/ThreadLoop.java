package frame.bola;

public abstract class ThreadLoop {

	/** A amarra do loop da thread. */
	private boolean loop;

	/** O intervalo de tempo da execução da rotina blocoRotina(). */
	private int time;

	/**
	 * Cria uma thread que submete o método blocoRotina() desta classe a um loop que
	 * será atualizado de tempos em tempos.
	 * 
	 * @param O intervalo de tempo da execução da rotina blocoRotina().
	 */
	public ThreadLoop(int time) {
		loop = false;
		this.time = time;
	}

	/** Inicializa a rotina do método blocoRotina() */
	public void iniciar() {
		if (loop) {
			return;
		}
		loop = true;
		new Thread(() -> {
			while (loop) {
				blocoRotina();
				try {
					Thread.sleep(time);
				} catch (Exception ex) {

				}

			}
		}).start();
	}

	/** Encerra a rotina p método blocoRotina() */
	public void encerrar() {
		loop = false;
	}

	/** Crie a rotina que o loop deverá executar. */
	abstract public void blocoRotina();

}
