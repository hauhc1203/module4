

function choosefile(filename) {
    let link= document.getElementById("duphong")
     if (filename.files[0]!=undefined){
         link.files=filename.files;
     }

        if (link.files[0]){
        let reader = new FileReader();
        reader.onload = function (e) {
            $('#image').attr('src', e.target.result);
        }
        reader.readAsDataURL(link.files[0])
    }
}