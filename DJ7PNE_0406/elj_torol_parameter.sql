create or replace procedure torol2(a IN number) is

begin

    delete from autok where kor>a;

end;