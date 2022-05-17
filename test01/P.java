//base case - interleaved statements may run in parallel
class P {
	public static void main(String [] args){
			T1 t1;
			O o;
		try {

			o = new O();
			t1 = new T1();

			o.qm1();
			t1.start();
			o.qm2();
			t1.join();

		} catch (Exception ex) {
		}
	}
}

class T1 extends Thread {
	L lock;

	public void run() {
		T1 t1;
		t1 = this;
		t1.qm();
	}

	public void qm() {}

}


class L {
}

class O {
	public void qm1() {}
	public void qm2() {}
}
