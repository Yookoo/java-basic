package state3;


public enum State {

	CHILD(){
		@Override
		public void live() {
			System.out.println("我是小孩,过着无忧无虑的童年生活!");
		}

		@Override
		public State next() {
			return YOUNTH;
		}		
	},YOUNTH(){

		@Override
		public void live() {
			System.out.println("我是青年,我对未来充满希望!");
		}
		@Override
		public State next() {
			return MIDDLE;
		}
		
	},MIDDLE(){

		@Override
		public void live() {
			System.out.println("我是中年人,我要为全家人而努力打拼!!");
		}

		@Override
		public State next() {
			return ELD;
		}}
	,ELD(){

			@Override
			public void live() {
				System.out.println("我是老年人,我要安享晚年!");
			}
			@Override
			public State next() {
		
				return null;
			}
			
		};
	
	public abstract void live();
	
	public abstract State next();
}
