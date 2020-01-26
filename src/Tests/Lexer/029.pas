program ferst;
var s:string;
    i,key:integer;
begin
     writeln('ente text'); readln(s);
     writeln('enter key ( 1 - 255)'); readln(key);
     for i:=1 to length(s) do s[i]:=char( ord(s[i]) + key  );
     writeln('text: ',s);
end.