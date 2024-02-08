package chapter13;//package com.edus.chapter13;

public class DeskPhone implements ITelephone {
		private boolean isOn = false;
		private boolean isRinging;
		private int myNumber;

		public void powerOn(){
				isOn = true;
				System.out.println("Desk phone is now powered on.\n");
			}

		@Override
		public void dial(long number)
			{
				// TODO: Implement this method
			}

		@Override
		public void answer()
			{
				
			}

		@Override
		public boolean isRinging()
			{
				if(isRinging){
					System.out.println("Desk phone ringing");
				}
				return false;
			}

		@Override
		public void powerOff()
			{
				// TODO: Implement this method
			}

		@Override
		public void message(String compose)
			{
				// TODO: Implement this method
			}

		@Override
		public String contactList(long contact)
			{
				// TODO: Implement this method
				return null;
			}
}
