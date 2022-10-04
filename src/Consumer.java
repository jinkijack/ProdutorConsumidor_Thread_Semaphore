import java.util.Random;

public class Consumer extends Thread{
	private final int id;
	private final CubbyHole ch;
	
	public Consumer(int id, CubbyHole ch) {
		this.id = id;
		this.ch = ch;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Lock.semCons.acquire();
				ch.get(id);
				//sleep(200);
                sleep(new Random().nextInt(1000));
                Lock.semProd.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
