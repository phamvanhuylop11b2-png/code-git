# HỆ THỐNG QUẢN LÝ CÔNG VIỆC
## Giới thiệu

Hệ thống Quản lý Công việc là ứng dụng Java Console được xây dựng nhằm hỗ trợ người dùng quản lý các công việc cá nhân. Chương trình cho phép người dùng đăng ký, đăng nhập và thực hiện các chức năng quản lý công việc như thêm, xem, sửa, tìm kiếm, đánh dấu hoàn thành và xóa công việc.
Dự án được xây dựng theo mô hình MVC (Model - View - Controller) kết hợp với DAO (Data Access Object) nhằm tách biệt dữ liệu, giao diện và xử lý nghiệp vụ, giúp mã nguồn rõ ràng và dễ bảo trì.

## Mục tiêu

- Xây dựng ứng dụng quản lý công việc trên nền tảng Java Console.
- Áp dụng mô hình MVC vào xây dựng chương trình.
- Thực hiện đầy đủ các thao tác CRUD.
- Quản lý người dùng và công việc bằng ArrayList.
- Rèn luyện kỹ năng lập trình hướng đối tượng (OOP).

## Cấu trúc dự án

src
│
├── MAIN
│   └── Main.java
│
├── MODEL
│   ├── User.java
│   └── Task.java
│
├── DAO
│   ├── UserDAO.java
│   └── TaskDAO.java
│
└── VIEW
    └── Menu.java
## Chức năng
### Quản lý tài khoản
- Đăng ký tài khoản
- Đăng nhập
- Đăng xuất

### Quản lý công việc
- Thêm công việc
- Xem danh sách công việc
- Sửa thông tin công việc
- Tìm kiếm công việc theo tên
- Đánh dấu công việc hoàn thành
- Xóa công việc
### Chức năng khác

- Giới thiệu chương trình
- Hướng dẫn sử dụng
- Thông tin hệ thống
## Mô tả các lớp

### User
Lưu thông tin người dùng.
Thuộc tính:

- id
- username
- email
- password
### Task

Lưu thông tin công việc.

Thuộc tính:
- id
- title
- description
- status
- userId
### UserDAO
Quản lý dữ liệu người dùng.

Các phương thức:
- register(User user)
- login(String email, String password)
- getAllUsers()
- getUserById(int id)
- updateUser(User user)
- deleteUser(int id)
### TaskDAO
Quản lý dữ liệu công việc.
Các phương thức:

- addTask(Task task)
- getAllTask(int userId)
- getTaskById(int id)
- updateTask(Task task)
- deleteTask(int id)
- searchTask(String keyword, int userId)
### Menu

Hiển thị giao diện Console và nhận dữ liệu từ người dùng.
Các chức năng:

- Hiển thị menu chính.
- Hiển thị menu quản lý công việc.
- Nhập chuỗi.
- Nhập số nguyên.
- Hiển thị thông báo.
### Main
Điều khiển toàn bộ chương trình.
Thực hiện:

- Khởi tạo chương trình.
- Xử lý menu chính.
- Xử lý đăng ký.
- Xử lý đăng nhập.
- Quản lý công việc.
- Đăng xuất.
- Kết thúc chương trình.
## Luồng hoạt động
Bắt đầu chương trình
        │
        ▼
Hiển thị Menu chính
        │
        ├── Đăng ký
        │
        ├── Đăng nhập
        │
        ├── Giới thiệu
        │
        ├── Hướng dẫn
        │
        ├── Thông tin hệ thống
        │
        └── Thoát
                 │
                 ▼
Đăng nhập thành công
                 │
                 ▼
Menu Quản lý công việc
                 │
                 ├── Thêm công việc
                 ├── Xem danh sách
                 ├── Sửa công việc
                 ├── Đánh dấu hoàn thành
                 ├── Tìm kiếm
                 ├── Xóa
                 └── Đăng xuất
## Hướng dẫn chạy chương trình

### Bước 1
Mở Eclipse.
### Bước 2
Import Project vào Eclipse.
### Bước 3
Chạy file: Main.java
### Bước 4
Đăng ký tài khoản.
### Bước 5
Đăng nhập vào hệ thống.
### Bước 6

Thực hiện các chức năng quản lý công việc.
## Kết quả đạt được

Chương trình đã hoàn thành các chức năng:
- Đăng ký người dùng.
- Đăng nhập người dùng.
- Thêm công việc.
- Xem danh sách công việc.
- Sửa công việc.
- Tìm kiếm công việc.
- Đánh dấu hoàn thành.
- Xóa công việc.
- Đăng xuất.
## Hạn chế
- Dữ liệu chỉ được lưu trong bộ nhớ (ArrayList).
- Khi tắt chương trình dữ liệu sẽ bị mất.
- Chưa kết nối cơ sở dữ liệu.
- Chưa có giao diện đồ họa.
## Hướng phát triển
- Kết nối MySQL để lưu trữ dữ liệu.
- Mã hóa mật khẩu người dùng.
- Thêm thời hạn (Deadline) cho công việc.
- Thêm mức độ ưu tiên.
- Thống kê số lượng công việc theo trạng thái.
- Sắp xếp công việc theo tên hoặc trạng thái.
- Xuất dữ liệu ra Excel hoặc PDF.
- Phát triển giao diện Java Swing hoặc JavaFX.

