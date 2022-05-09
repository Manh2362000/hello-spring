document.addEventListener('DOMContentLoaded', function () {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    var getProductDetailUrl = `http://localhost:8080/api/nv1/products/`${id};
    var xhr = new XMLHttpRequest();
    if (xhr.readyState === 4) {
        if (xhr.status === 200) {
            var element = JSON.parse(xhr.responseText);
            var tableTag = document.querySelector('#product-table');
            tableTag.innerHTML += `<tr>
                                       <td>${element.id}</td>
                                       <td>${element.name}</td>
                                       <td>${element.description}</td>
                                       <td>${element.price}</td>
                                       <td>
                                            <a href="/form.html?id=${element.id}">edit</a>
                                            <a href="javascript:void(0)"onclick="deleteProduct(${element.id})">delete</a>
                                        </td>
                                       </tr>`;
        } else {
            alert('Khong the load san pham!');
        }
    }
    xhr.open('GET',getProductDetailUrl,fasle);
    xhr.send();
})