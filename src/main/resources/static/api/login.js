function login(formData) {

    axios.post('http://localhost:8080/admin/login', formData)

        .then(response => {
            // 登录成功，保存 token
            const token = response.data;
            localStorage.setItem('token', token);

            // 跳转到主页
            window.location.href = '/home.html';
        })
        .catch(error => {
            // 登录失败，提示错误信息
            console.error(error);
            alert('登录失败，请检查用户名和密码！');
        });
}
