package state3;


public enum State {

	CHILD(){
		@Override
		public void live() {
			System.out.println("����С��,�����������ǵ�ͯ������!");
		}

		@Override
		public State next() {
			return YOUNTH;
		}		
	},YOUNTH(){

		@Override
		public void live() {
			System.out.println("��������,�Ҷ�δ������ϣ��!");
		}
		@Override
		public State next() {
			return MIDDLE;
		}
		
	},MIDDLE(){

		@Override
		public void live() {
			System.out.println("����������,��ҪΪȫ���˶�Ŭ����ƴ!!");
		}

		@Override
		public State next() {
			return ELD;
		}}
	,ELD(){

			@Override
			public void live() {
				System.out.println("����������,��Ҫ��������!");
			}
			@Override
			public State next() {
		
				return null;
			}
			
		};
	
	public abstract void live();
	
	public abstract State next();
}
