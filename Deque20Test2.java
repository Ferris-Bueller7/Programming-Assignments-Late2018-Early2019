import java.util.NoSuchElementException;
public class Deque20Test2
{
   public static void main(String[] args)
   {
      boolean pass = true;
      Deque20<Integer> d = new Deque20<>();

      try { d.peek(); pass=false; }
      catch(NoSuchElementException e) { }
      catch(Exception e) { pass=false; }
      //System.out.print(pass);

      try { d.pop(); pass=false; }
      catch(NoSuchElementException e) { }
      catch(Exception e) { pass=false; }

        try { d.remove(); pass=false; }
        catch(NoSuchElementException e) { }
        catch(Exception e) { pass=false; }

        d.push(1); d.push(2); d.push(3);
        pass = pass && !d.isEmpty() && (d.size()==3) && (d.peek()==3) && (d.pop()==3);
        pass = pass && !d.isEmpty() && (d.size()==2) && (d.peek()==2) && (d.pop()==2);
        pass = pass && !d.isEmpty() && (d.size()==1) && (d.peek()==1) && (d.pop()==1);
        pass = pass && d.isEmpty() && (d.size()==0);

        d.add(1); d.add(2); d.add(3);
        pass = pass && !d.isEmpty() && (d.size()==3) && (d.peek()==1) && (d.remove()==1);
        pass = pass && !d.isEmpty() && (d.size()==2) && (d.peek()==2) && (d.remove()==2);
        pass = pass && !d.isEmpty() && (d.size()==1) && (d.peek()==3) && (d.remove()==3);
        pass = pass && d.isEmpty() && (d.size()==0);

        d.add(1); d.push(2); d.add(3);
        pass = pass && !d.isEmpty() && (d.size()==3) && (d.peek()==2) && (d.remove()==2);
        pass = pass && !d.isEmpty() && (d.size()==2) && (d.peek()==1) && (d.pop()==1);
        pass = pass && !d.isEmpty() && (d.size()==1) && (d.peek()==3) && (d.remove()==3);
        pass = pass && d.isEmpty() && (d.size()==0);

        try { d.peek(); pass=false; }
        catch(NoSuchElementException e) { }
        catch(Exception e) { pass=false; }

        try { d.pop(); pass=false; }
        catch(NoSuchElementException e) { }
        catch(Exception e) { pass=false; }

        try { d.remove(); pass=false; }
        catch(NoSuchElementException e) { }
        catch(Exception e) { pass=false; }

        System.out.println(pass);
   }
}        