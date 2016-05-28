//название двух селектов
function swap(from,who) {

    var sel=document.getElementById(from);
    var sel2=document.getElementById(who);
    for (var i = 0; i < sel.options.length; i++) {
        var option = sel.options[i];

        if(option.selected) {
            add(sel2,option);
            deleteGroup(sel,option)
           --i;
        }
    }
};
function add(select,val) {
    var elems = select.getElementsByTagName('optgroup');

    for(var i=0; i<elems.length; i++)
    {
        if(elems[i].label.localeCompare(val.value)==0)
        {
            elems[i].appendChild(val);
            return;
        }
        else if(elems[i].label.localeCompare(val.value)==-1)
        {
            var group = document.createElement('optgroup');
            group.label=val.value;
            group.appendChild(val);
            select.insertBefore(group,elems[i]);
            return;
        }
    }
    var group = document.createElement('optgroup');
    group.label=val.value;
    group.appendChild(val);
    select.appendChild(group);
}
function deleteGroup(select,val) {
    var elems = select.getElementsByTagName('optgroup');
    for(var i=0; i<elems.length; i++)
    {
        if(elems[i].getElementsByTagName('option').length==0)
            select.removeChild(elems[i]);
    }
}
function submit(form) {
    document.getElementById(form).submit();
}
function createFormQuestions(idSelect,idPerent,idForm)
{
    var select = document.getElementById(idSelect);
    var elems = select.getElementsByTagName('option');
    var form = document.getElementById(idForm);

    var option=document.createElement('input');
    option.setAttribute('name','idCol');
    option.setAttribute('value',document.getElementById(idPerent).options[document.getElementById(idPerent).selectedIndex].value);
    option.setAttribute('hidden','true');
    form.appendChild(option);

    for(var i=0; i<elems.length; i++)
    {
        var option=document.createElement('input');
        option.setAttribute('name','objectFromWithIDs['+i+'].id');
        option.setAttribute('value',elems[i].id.substr(1));
        option.setAttribute('hidden','true');
        form.appendChild(option);
    }
    form.submit();
}
function dump(obj) {
    var out = "";
     if(obj && typeof(obj) == "object"){
        for (var i in obj) {
            // if(i=='path'||i=='text')
            out += i + ": " + obj[i] +"\n";
        }
    } else {
        out = obj;
    }
    alert(out);
}