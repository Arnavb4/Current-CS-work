public interface Plant
{
   public int getHeight();
   public int getBlooms();
   public String getSunlight();
   public String getSound();
   public String getOccupation();
   public int getValue();
   public int getExpertise();
   public void setSunlight(String newSun);
   public void setWater(double tablespoons);
   public void setSound(String newSound);
   public void setOccupation(String newOccupation);
   public void grow();
   public int trim();
   public void statusReport();
   public boolean isAlive();
   //8) Why doesn't this interface need toString() defined?
}