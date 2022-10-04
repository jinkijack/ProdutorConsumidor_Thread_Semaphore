import java.util.Random;
public class Producer extends Thread{
	private final int id;
	private final CubbyHole ch;
	
	public Producer(int id, CubbyHole ch) {
		this.id = id;
		this.ch = ch;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			try {
				Lock.semProd.acquire();
				ch.set(id, i);

				sleep(new Random().nextInt(1000));
				Lock.semCons.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}