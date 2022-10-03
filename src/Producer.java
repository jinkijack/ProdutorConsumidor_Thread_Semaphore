
public class Producer extends Thread{
	private int id;
	private CubbyHole ch;
	
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
				sleep(200);
				Lock.semCons.release();
			} catch (InterruptedException e) {}
		}
	}
}