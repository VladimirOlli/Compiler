program cycle_for;
var i,kn : byte; x:real;
begin
   kn:=0;
     for i:=1 to 10 do
       begin
          writeln('enter ',i,'  ');
          readln(x);
       if x>0 then kn:=kn+1 
end;
   writeln('you ',kn,' answer');
readln
end.