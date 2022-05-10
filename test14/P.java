//synchronized statements in thread can run in parallel with non-synchronized, interleaved statements of parent
class P {
	public static void main(String [] args){
			T1 t1;
			O o;
			L lock;
		try {
			t1 = new T1();
			lock = new L();

			t1.l = lock;

			t1.start();
			o.qm();
			t1.join();
		} catch (Exception ex) {
		}
	}
}

class T1 extends Thread {
	L l;

	public void run() {
		T1 t1;
		t1 = this;

		synchronized(l) {
			t1.qm();
		}
	}

	public void qm() {}

}


class O {
	public void qm() {} 
}
