function myQuery(selector, parent) {
    if (parent == null) {
        // 부모 태그가 지정되어 있지 않으면 그 부모 태그 아래에서 태그를 찾는다.
        var e = document.querySelector(selector);
    } else {
        var e = parent.querySelector(selector);
    }
    e.css = function (style, value) {
        e.style[name] = value;
    };

    e.find = function (selector) {
        return myQuery(selector, e);
    };

    return e;
}

var $ = myQuery;

function gogila(aaa) {
    return (
        <div>
            <span>{aaa}</span>
        </div>
    );
}
