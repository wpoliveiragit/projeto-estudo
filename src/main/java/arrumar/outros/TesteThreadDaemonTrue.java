package arrumar.outros;

/**
 *
 * @author Cantina
 */
public class TesteThreadDaemonTrue {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
						System.out.println("s");
					} catch (InterruptedException e) {

					}
				}
			}
		});
		t.start();
	}

}
