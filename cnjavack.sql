-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 09, 2024 lúc 02:09 PM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cnjavack`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`, `description`) VALUES
(1, 'Nhà phố', 'Bất động sản nhà phố tại các khu đô thị hoặc trung tâm thành phố.'),
(2, 'Căn hộ', 'Các căn hộ chung cư cao cấp và bình dân.'),
(3, 'Đất nền', 'Đất nền tại khu vực đô thị và ngoại ô.'),
(4, 'Biệt thự', 'Biệt thự cao cấp, nghỉ dưỡng.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `favorites`
--

CREATE TABLE `favorites` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `favorites`
--

INSERT INTO `favorites` (`id`, `user_id`, `property_id`, `created_at`) VALUES
(1, 1, 4, '2024-12-05 10:51:55'),
(2, 2, 2, '2024-12-05 10:51:55');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `paypal_transactions`
--

CREATE TABLE `paypal_transactions` (
  `id` bigint(20) NOT NULL,
  `payment_id` varchar(255) NOT NULL,
  `payer_id` varchar(255) NOT NULL,
  `payer_email` varchar(255) NOT NULL,
  `transaction_id` varchar(255) NOT NULL,
  `amount` decimal(38,2) NOT NULL,
  `currency_code` varchar(255) NOT NULL,
  `payment_status` varchar(255) NOT NULL,
  `payment_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `order_id` varchar(255) DEFAULT NULL,
  `transaction_details` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `paypal_transactions`
--

INSERT INTO `paypal_transactions` (`id`, `payment_id`, `payer_id`, `payer_email`, `transaction_id`, `amount`, `currency_code`, `payment_status`, `payment_date`, `order_id`, `transaction_details`, `user_id`) VALUES
(1, 'PAYID-M5JA4XY56293939B6713015X', 'RYB66RKXZG5L6', 'sb-jo47jq30088882@personal.example.com', 'PAYID-M5JA4XY56293939B6713015X', 0.40, 'USD', 'approved', '2024-12-05 20:35:35', NULL, 'Payment description', 1),
(2, 'PAYID-M5JBAYY8X220333YU6858357', 'RYB66RKXZG5L6', 'sb-jo47jq30088882@personal.example.com', 'PAYID-M5JBAYY8X220333YU6858357', 4.00, 'USD', 'approved', '2024-12-05 20:43:23', NULL, 'Payment description', 1),
(3, 'PAYID-M5JBBPI8VN97167PA505032K', 'RYB66RKXZG5L6', 'sb-jo47jq30088882@personal.example.com', 'PAYID-M5JBBPI8VN97167PA505032K', 5.29, 'USD', 'approved', '2024-12-05 20:44:52', NULL, 'Payment description', 1),
(4, 'PAYID-M5JBCJQ17H12118X4018550W', 'RYB66RKXZG5L6', 'sb-jo47jq30088882@personal.example.com', 'PAYID-M5JBCJQ17H12118X4018550W', 85.25, 'USD', 'approved', '2024-12-05 20:46:37', NULL, 'Payment description', 1),
(5, 'PAYID-M5JBC5I9JA96603HN181345X', 'RYB66RKXZG5L6', 'sb-jo47jq30088882@personal.example.com', 'PAYID-M5JBC5I9JA96603HN181345X', 12.00, 'USD', 'approved', '2024-12-05 20:47:55', NULL, 'Payment description', 1),
(6, 'PAYID-M5JBEVI13U96230TS340410G', 'RYB66RKXZG5L6', 'sb-jo47jq30088882@personal.example.com', 'PAYID-M5JBEVI13U96230TS340410G', 4.00, 'USD', 'approved', '2024-12-05 20:51:41', NULL, 'Payment description', 2),
(7, 'PAYID-M5JBFQY6E409500587570714', 'RYB66RKXZG5L6', 'sb-jo47jq30088882@personal.example.com', 'PAYID-M5JBFQY6E409500587570714', 4.00, 'USD', 'approved', '2024-12-05 20:53:30', NULL, 'Payment description', 3),
(8, 'PAYID-M5LGHXQ3XU68998B9556154E', 'RYB66RKXZG5L6', 'sb-jo47jq30088882@personal.example.com', 'PAYID-M5LGHXQ3XU68998B9556154E', 400.00, 'USD', 'approved', '2024-12-09 03:28:59', NULL, 'Payment description', 3),
(9, 'PAYID-M5LGJBQ0YM15111NS069373X', 'RYB66RKXZG5L6', 'sb-jo47jq30088882@personal.example.com', 'PAYID-M5LGJBQ0YM15111NS069373X', 400.00, 'USD', 'approved', '2024-12-09 03:31:26', NULL, 'Payment description', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `properties`
--

CREATE TABLE `properties` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `price` decimal(38,2) NOT NULL,
  `location` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `owner_id` bigint(20) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `acreage` varchar(255) NOT NULL,
  `method` int(11) DEFAULT 0 CHECK (`method` in (0,1))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `properties`
--

INSERT INTO `properties` (`id`, `title`, `description`, `price`, `location`, `type`, `status`, `category_id`, `owner_id`, `created_at`, `updated_at`, `acreage`, `method`) VALUES
(1, 'Nhà phố 3 tầng quận 1', 'Nhà phố 3 tầng, thiết kế hiện đại, diện tích 120m2.', 15000000000.00, 'Quận 1, TP. Hồ Chí Minh', 'Completed', 'Available', 1, 1, '2024-12-05 10:49:46', '2024-12-09 02:56:09', '50', 0),
(2, 'Căn hộ 2 phòng ngủ', 'Căn hộ chung cư 2 phòng ngủ, nội thất đầy đủ.', 2500000000.00, 'Quận 7, TP. Hồ Chí Minh', 'Completed', 'Available', 2, 1, '2024-12-05 10:49:46', '2024-12-09 02:59:52', '50', 0),
(3, 'Đất nền quận 9', 'Đất nền quận 9, thích hợp xây nhà.', 5000000000.00, 'Quận 9, TP. Hồ Chí Minh', 'PENDING_PAYMEN', 'Available', 3, 2, '2024-12-05 10:49:46', '2024-12-09 02:48:25', '50', 0),
(4, 'Biệt thự ven biển', 'Biệt thự cao cấp, view biển, thiết kế sang trọng.', 35000000000.00, 'Vũng Tàu', 'PENDING_PAYMEN', 'Available', 4, 2, '2024-12-05 10:49:46', '2024-12-09 02:48:25', '50', 0),
(5, 'thanhkhoi939@gmail.com', 'demo thu', 22322222.00, 'viet nam tan thong hoi', 'Completed', 'Not Available', 1, 1, '2024-12-08 21:00:11', '2024-12-09 12:37:34', '222', 1),
(6, 'ban nha o tay ninh', 'demo thu lan thu n', 22322222.00, 'tay ninh nui ba', 'Completed', 'Available', 1, 1, '2024-12-08 21:00:32', '2024-12-09 12:39:02', '222', 1),
(7, 'thanhkhoi939@gmail.com', 'sadssssssssss', 22322222.00, 'demo', 'Completed', 'Available', 1, 1, '2024-12-08 21:01:15', '2024-12-09 03:02:23', '222', 1),
(8, 'thanhkhoi939@gmail.com', 'sadssssssssss', 22322222.00, 'demo', 'Completed', 'Available', 1, 1, '2024-12-08 21:02:12', '2024-12-09 03:16:28', '222', 1),
(9, 'thanhkhoi939@gmail.com', 'sadssssssssss', 1231233.00, 'demo', 'Completed', 'Available', 2, 1, '2024-12-08 21:21:33', '2024-12-09 03:31:44', '2112', 1),
(10, 'thanhkhoi939@gmail.com', 'sadssssssssss', 1231233.00, 'demo', 'Completed', 'Available', 2, 1, '2024-12-08 21:22:39', '2024-12-09 03:33:10', '2112', 1),
(11, 'thanhkhoi939@gmail.com', 'sadssssssssss', 1231233.00, 'demo', 'Completed', 'Available', 2, 1, '2024-12-08 21:23:10', '2024-12-09 03:34:19', '2112', 1),
(12, 'thanhkhoi939@gmail.com', 'sadssssssssss', 1231233.00, 'demo', 'PENDING_PAYMEN', 'Available', 2, 1, '2024-12-08 21:23:59', '2024-12-09 02:48:25', '2112', 1),
(13, 'thanhkhoi939@gmail.com', 'sadssssssssss', 1231233.00, 'demo', 'PENDING_PAYMEN', 'Available', 2, 1, '2024-12-08 21:27:29', '2024-12-09 02:48:25', '2112', 1),
(14, 'thanhkhoi939@gmail.com', 'sadssssssssss', 1231233.00, 'demo', 'Completed', 'Available', 2, 1, '2024-12-08 21:28:28', '2024-12-09 03:26:06', '2112', 1),
(15, 'thanhkhoi939@gmail.com', 'sadssssssssss', 1231233.00, 'demo', 'Completed', 'Available', 2, 1, '2024-12-08 21:29:14', '2024-12-09 03:16:17', '2112', 0),
(16, 'thanhkhoi939@gmail.com', 'sadssssssssss', 1231233.00, 'demo', 'Completed', 'Available', 2, 1, '2024-12-08 21:30:29', '2024-12-09 03:15:58', '2112', 0),
(17, 'demo1 c chi', 'sadssssssssss', 12300000000.00, '124 duong ho van tang1140530531', 'Completed', 'Available', 2, 1, '2024-12-08 22:20:37', '2024-12-09 03:15:52', '233', 1),
(18, 'demo3 c chi', 'sadssssssssss', 12000000.00, '124 duong ho van tangXã Mê LinhHuyện Mê LinhThành phố Hà Nội', 'Completed', 'Available', 1, 1, '2024-12-08 23:18:11', '2024-12-09 03:05:33', '12', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `property_details`
--

CREATE TABLE `property_details` (
  `id` bigint(20) NOT NULL,
  `pcontent` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `bhk` varchar(255) NOT NULL,
  `stype` varchar(255) NOT NULL,
  `bedroom` int(11) NOT NULL,
  `bathroom` int(11) NOT NULL,
  `balcony` varchar(255) NOT NULL,
  `kitchen` int(11) NOT NULL,
  `hall` int(11) NOT NULL,
  `floor` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `location` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `totalfloor` varchar(255) NOT NULL,
  `properties_id` bigint(20) NOT NULL,
  `namecontract` varchar(255) NOT NULL,
  `emailcontract` varchar(255) NOT NULL,
  `phonecontract` varchar(255) NOT NULL,
  `methodpost` varchar(255) NOT NULL,
  `time` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `property_details`
--

INSERT INTO `property_details` (`id`, `pcontent`, `type`, `bhk`, `stype`, `bedroom`, `bathroom`, `balcony`, `kitchen`, `hall`, `floor`, `price`, `location`, `city`, `state`, `totalfloor`, `properties_id`, `namecontract`, `emailcontract`, `phonecontract`, `methodpost`, `time`) VALUES
(1, 'Quý vị đang xem nội dung tin rao \"Chính chủ kẹt tiền bán gấp lô đất cắt lỗ 200tr\" - Mã tin 38597297. Mọi thông tin, nội dung liên quan tới tin rao này là do người đăng tin đăng tải và chịu trách nhiệm. Batdongsan.com.vn luôn cố gắng để các thông tin được ', 'house', '4', 'sale', 4, 2, '0', 1, 1, '2nd floor', 1869, '124 cu chi', 'ho chi minh', 'viet nam', '2', 1, '', '', '', '', 0),
(2, '123123123', 'null', '1', 'Cho thue', 1, 1, '1', 1, 0, 'a', 1999, 's', 'a', 'a', '2', 16, 'demo', 'thanhkhoi939@gmail.com', '0389177663', 'bth', 0),
(3, 'cho dai', '11405', '0', 'Ban', 1, 1, '1', 1, 0, 'Khong co thong tin', 1999, '124 duong ho van tang', '31', '305', '1', 17, 'demo1', 'thanhkhoi939@gmail.com', '0389177663', 'bth', 0),
(4, '1', 'Xã Mê Linh', '0', 'Cho thue', 1, 1, '1', 1, 0, 'Khong co thong tin', 1999, '124 duong ho van tang', 'Thành phố Hà Nội', 'Huyện Mê Linh', '1', 18, 'demo3', 'thanhkhoi939@gmail.com', '0389177663', 'bth', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `property_images`
--

CREATE TABLE `property_images` (
  `id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL,
  `image_url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `property_images`
--

INSERT INTO `property_images` (`id`, `property_id`, `image_url`) VALUES
(1, 1, 'https://example.com/images/house1.jpg'),
(2, 1, 'https://example.com/images/house1-2.jpg'),
(3, 2, 'https://example.com/images/apartment1.jpg'),
(4, 3, 'https://example.com/images/land1.jpg'),
(5, 4, 'https://example.com/images/villa1.jpg'),
(6, 4, 'https://example.com/images/villa1-2.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reviews`
--

CREATE TABLE `reviews` (
  `id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `rating` int(11) NOT NULL CHECK (`rating` between 1 and 5),
  `comment` text DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `reviews`
--

INSERT INTO `reviews` (`id`, `property_id`, `user_id`, `rating`, `comment`, `created_at`) VALUES
(1, 1, 2, 5, 'Nhà đẹp, đúng như mô tả.', '2024-12-05 10:51:50'),
(2, 2, 1, 4, 'Căn hộ ổn nhưng giá hơi cao.', '2024-12-05 10:51:50'),
(3, 4, 1, 5, 'Biệt thự tuyệt vời, thiết kế hiện đại.', '2024-12-05 10:51:50');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `transactions`
--

CREATE TABLE `transactions` (
  `id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL,
  `buyer_id` bigint(20) DEFAULT NULL,
  `seller_id` bigint(20) NOT NULL,
  `transaction_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `price` decimal(38,2) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `transactions`
--

INSERT INTO `transactions` (`id`, `property_id`, `buyer_id`, `seller_id`, `transaction_date`, `price`, `status`) VALUES
(1, 1, 2, 1, '2024-01-01 03:00:00', 15000000000.00, 'Completed'),
(2, 3, 1, 2, '2024-02-01 08:00:00', 5000000000.00, 'Completed'),
(3, 1, NULL, 1, '2024-12-09 02:52:32', 604197.00, 'Completed'),
(4, 1, NULL, 1, '2024-12-09 02:56:09', 36300.00, 'Completed'),
(5, 2, NULL, 1, '2024-12-09 02:59:52', 0.00, 'Completed'),
(6, 5, NULL, 1, '2024-12-09 03:01:24', 0.00, 'Completed'),
(7, 6, NULL, 1, '2024-12-09 03:02:16', 0.00, 'Completed'),
(8, 7, NULL, 1, '2024-12-09 03:02:23', 0.00, 'Completed'),
(9, 18, NULL, 1, '2024-12-09 03:05:33', 36300.00, 'Completed'),
(10, 17, NULL, 1, '2024-12-09 03:15:52', 0.00, 'Completed'),
(11, 16, NULL, 1, '2024-12-09 03:15:58', 0.00, 'Completed'),
(12, 15, NULL, 1, '2024-12-09 03:16:17', 0.00, 'Completed'),
(13, 8, NULL, 1, '2024-12-09 03:16:28', 0.00, 'Completed'),
(14, 14, NULL, 1, '2024-12-09 03:26:06', 0.00, 'Completed'),
(15, 14, NULL, 1, '2024-12-09 03:26:14', 0.00, 'Completed'),
(16, 14, NULL, 1, '2024-12-09 03:27:53', 0.00, 'Completed'),
(17, 9, NULL, 1, '2024-12-09 03:31:44', 0.00, 'Completed'),
(18, 9, NULL, 1, '2024-12-09 03:31:49', 445199.00, 'Completed'),
(19, 10, NULL, 1, '2024-12-09 03:33:10', 48989.00, 'Completed'),
(20, 11, NULL, 1, '2024-12-09 03:34:19', 858578.00, 'Completed');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `money` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `phone`, `role`, `created_at`, `money`) VALUES
(1, 'Nguyễn Văn A', 'nguyenvana@gmail.com', 'password123', '0987654321', 'User', '2024-12-05 10:49:40', 8650844),
(2, 'Trần Thị B', 'tranthib@gmail.com', 'password456', '0987654322', 'User', '2024-12-05 10:49:40', 96000),
(3, 'Admin', 'admin@batdongsan.com', 'admin123', '0987654323', 'Admin', '2024-12-05 10:49:40', 10100000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `favorites`
--
ALTER TABLE `favorites`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `property_id` (`property_id`);

--
-- Chỉ mục cho bảng `paypal_transactions`
--
ALTER TABLE `paypal_transactions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `properties`
--
ALTER TABLE `properties`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `owner_id` (`owner_id`);

--
-- Chỉ mục cho bảng `property_details`
--
ALTER TABLE `property_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `properties_id` (`properties_id`);

--
-- Chỉ mục cho bảng `property_images`
--
ALTER TABLE `property_images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `property_id` (`property_id`);

--
-- Chỉ mục cho bảng `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `property_id` (`property_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `property_id` (`property_id`),
  ADD KEY `buyer_id` (`buyer_id`),
  ADD KEY `seller_id` (`seller_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `favorites`
--
ALTER TABLE `favorites`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `paypal_transactions`
--
ALTER TABLE `paypal_transactions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `properties`
--
ALTER TABLE `properties`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `property_details`
--
ALTER TABLE `property_details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `property_images`
--
ALTER TABLE `property_images`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `favorites`
--
ALTER TABLE `favorites`
  ADD CONSTRAINT `favorites_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `favorites_ibfk_2` FOREIGN KEY (`property_id`) REFERENCES `properties` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `paypal_transactions`
--
ALTER TABLE `paypal_transactions`
  ADD CONSTRAINT `paypal_transactions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `properties`
--
ALTER TABLE `properties`
  ADD CONSTRAINT `properties_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `properties_ibfk_2` FOREIGN KEY (`owner_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `property_details`
--
ALTER TABLE `property_details`
  ADD CONSTRAINT `property_details_ibfk_1` FOREIGN KEY (`properties_id`) REFERENCES `properties` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `property_images`
--
ALTER TABLE `property_images`
  ADD CONSTRAINT `property_images_ibfk_1` FOREIGN KEY (`property_id`) REFERENCES `properties` (`id`);

--
-- Các ràng buộc cho bảng `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`property_id`) REFERENCES `properties` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`property_id`) REFERENCES `properties` (`id`),
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`buyer_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `transactions_ibfk_3` FOREIGN KEY (`seller_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
