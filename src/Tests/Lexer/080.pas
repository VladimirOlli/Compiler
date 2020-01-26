Program DEED;
Var
   K, Des, Ed : Integer;

Begin
   Write('enter nomber'); Readln(K);

   Des:= K DIV 10;
   Ed:= K MOD 10;

   Writeln('desatkov =', Des);
   Writeln('edinits =', Ed);

Readln; 
End.