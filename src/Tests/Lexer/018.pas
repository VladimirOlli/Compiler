﻿const LIMIT = 10000;
var n,i,j,s,lim,c,d : word;
begin {  }
  for i:=1 to LIMIT do begin
     s:=1; lim:=round(sqrt(i));
     for j:=2 to lim do begin
       c:=i mod j;
       d:=i div j;
       if c = 0 then begin
          inc(s,j);
          if (j<>d) then inc(s,d); {}
       end;
     end;
     if s=i then writeln(i);
  end;
end.