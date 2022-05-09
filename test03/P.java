class P {
	public static void main(String [] args){
			T1 t1;
			O o;
		try {

			o = new O();
			t1 = new T1();

			o.qm();
			t1.start();
			t1.join();

		} catch (Exception ex) {
		}
	}
}

class T1 extends Thread {

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
	public void qm() {}
}
