 program pls_postavte_4;

 var
 m, n, i, min, mindiv: word;

 begin
 readln(m, n);
 mindiv := 1;
 if n < m then min := n else min := m;
 for i := 2 to min do begin
 if (n mod i = 0) and (m mod i = 0) then begin
 mindiv := i;
 break
 end
 end;
 if mindiv <> 1 then writeln(mindiv) else writeln('No divisors!')
 end.