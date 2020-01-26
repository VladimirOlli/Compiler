var a:array[1..10] of integer;
    x:integer;
    i:integer;
begin
     writeln('write 10 ');
     for i:=1 to 10 do readln( a[i] );
     x:=a[10];
     for i:=10 to 2 do begin
       a[i]:=a[i-1];
     end;
     a[1]:=x;
     writeln('Answer:');
     for i:=1 to 10 do writeln( a[i] );
end.