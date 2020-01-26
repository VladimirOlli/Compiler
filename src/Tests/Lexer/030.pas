program dr;
var s,r:string;
    state,i:integer;
begin
     writeln('enter text with comment'); readln(s);
     r:=''; state:=0; 
     for i:=1 to length(s) do begin
        case s[i] of
           '{': if state=0 then state:=1;  
           '}': if state=1 then state:=0   
                else r:=r+s[i];            
           else if state=0 then r:=r+s[i]; 
        end;
     end;
     writeln('new:'); writeln(r);
end.