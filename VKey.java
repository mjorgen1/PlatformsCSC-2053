public class VKey {
  protected int vid;
  
  public VKey(int v) {
    vid = v;
  }
  public int getVid() {
    return vid;
  }

  public void setVid(int v) {
    vid = v;
  }
  
  @Override
  public boolean equals(Object obj) {
    if(obj == null) return false;
    if(obj == this) return true;
    if(!(obj instanceof VKey)) return false;
    VKey v = (VKey)obj;
    if(vid == v.vid) return true;
    else return false;
  }

  @Override
  public int hashCode() {
    return vid;
  }
}
