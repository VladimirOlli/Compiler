﻿program calc_stepen;

var
  a, b, h, i: integer;
  c: real;

begin
  b := 1;
  readln( a, h);
  for i := 1 to abs(h) do
    b := b * a;
  if h < 0 then
    c := 1 / b
  else
    c := b;

  writeln( c);

end.