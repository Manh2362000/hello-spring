document.addEventListener('DOMContentLoaded',function (){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function (){
        if(xhr.readyState === 4 && xhr.status === 200){
          var data = JSON.parse(xhr.responseText);
          var tableTag = document.querySelector('#product-table');
          for (let index = 0;index < data.length;index++){
              const element = data[index];
              tableTag.innerHTML += `<tr>
                                       <td>${element.id}</td>
                                       <td>${element.name}</td>
                                       <td>${element.description}</td>
                                       <td>${element.price}</td>
                                       <td>
                                       <a href="/form.html?id=${element.id}">edit</a>
                                       <a href="/detail.html?id=${element.id}">detail</a>
                                       <a href="javascript:void(0)"onclick="deleteProduct(${element.id})"></a>
                                       </td>
                                       </tr>`;
          }
        }
        xhr.open('GET', 'http://localhost:8080/api/nv1/products/', false); // gửi đi đâu, theo cách nào.
        xhr.send(); // phóng xe đi.
    }
});
function deleteProduct(id) {
    if (id === undefined || id === null) {
        return;
    }
    if (confirm('are you sure?')) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                alert('success');
                window.location.href = '/index.html';
            }
        };
        xhr.open('DELETE', 'http://localhost:8080/api/nv1/products/'+ id, false); // gửi đi đâu, theo cách nào.
        xhr.send(); // phóng xe đi.
    }
}