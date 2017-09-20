public class Driver {
  public static void main(String[] args) {
    HMap<VKey,String> m = new HMap<VKey,String>();
    VKey v1 = new VKey(1112); // Abe Lincoln
    VKey v2 = new VKey(1311); // JFK
    VKey v3 = new VKey(1561); // Gandhi
    VKey v4 = new VKey(4151); // Van Gogh
    VKey v5 = new VKey(1452); // MLK
    VKey v6 = new VKey(5150); // Orwell
    VKey v7 = new VKey(5650); // Picasso
    VKey v8 = new VKey(1451); // Bill Gates
    VKey v9 = new VKey(1211); // Plato

    m.put(v1,"Abe Lincoln");
    m.put(v2,"JFK");
    m.put(v3,"Gandhi");
    m.put(v4,"Van Gogh");
    m.put(v5,"MLK");
    m.put(v6,"Orwell");
    m.put(v7,"Picasso");
    m.put(v8,"Bill Gates");
    m.put(v9,"Plato");

    System.out.println("Should print Picasso : "+ m.get(v7));
    System.out.println("Shoud print Orwell : " + m.get(v6));
    System.out.println("Shoud print Van Gogh : " + m.get(v4));

    System.out.println("Contains Van Gogh? (should be true) " + m.contains(v4));

    System.out.println("Removing Van Gogh");
    m.remove(v4);
    System.out.println("Contains Van Gogh? (should be false) " + m.contains(v4));

    System.out.println("Should print Picasso : "+ m.get(v7));
    System.out.println("Shoud print Orwell : " + m.get(v6));
    System.out.println("Shoud print null : " + m.get(v4));
  }
}
