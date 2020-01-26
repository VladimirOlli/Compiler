program pop;
var
    let, let11, god, goda: set of byte;
    age, n: byte;
begin
    let := [0,5,6,7,8,9];
    let11 := [11,12,13,14];
    god := [1];
    write('let: ');
    readln(age);
    if (age in let11) or (age mod 100 in let11) then
        writeln(age, ' let')
    else begin
        n := age mod 10;
        if n in let then
            writeln(age, ' let')
        else
            if n in god then
                writeln(age, ' god')
            else
                writeln(age, ' goda ')
    end;
 
readln;
end.