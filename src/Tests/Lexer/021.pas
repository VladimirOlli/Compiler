var a:array[1..10] of integer;
    i,j,m,p,n:integer;
begin
     writeln('write 10 ');
     for i:=1 to 10 do readln( a[i] );
     m:=1; p:=1;
     for i:=1 to 10 do begin
       n:=0;
       for j:=1 to 10 do begin
          if a[i]=a[j] then inc(n);
       end;
       if n>m then begin
          m:=n; p:=i;
       end;
     end;
     writeln('Answer:',a[p]);
end.