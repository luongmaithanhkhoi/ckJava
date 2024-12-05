-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 05, 2024 lúc 03:48 PM
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
  `acreage` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `properties`
--

INSERT INTO `properties` (`id`, `title`, `description`, `price`, `location`, `type`, `status`, `category_id`, `owner_id`, `created_at`, `updated_at`, `acreage`) VALUES
(1, 'Nhà phố 3 tầng quận 1', 'Nhà phố 3 tầng, thiết kế hiện đại, diện tích 120m2.', 15000000000.00, 'Quận 1, TP. Hồ Chí Minh', 'House', 'Available', 1, 1, '2024-12-05 10:49:46', '2024-12-05 12:38:38', '50'),
(2, 'Căn hộ 2 phòng ngủ', 'Căn hộ chung cư 2 phòng ngủ, nội thất đầy đủ.', 2500000000.00, 'Quận 7, TP. Hồ Chí Minh', 'Apartment', 'Available', 2, 1, '2024-12-05 10:49:46', '2024-12-05 12:38:38', '50'),
(3, 'Đất nền quận 9', 'Đất nền quận 9, thích hợp xây nhà.', 5000000000.00, 'Quận 9, TP. Hồ Chí Minh', 'Land', 'Available', 3, 2, '2024-12-05 10:49:46', '2024-12-05 12:38:38', '50'),
(4, 'Biệt thự ven biển', 'Biệt thự cao cấp, view biển, thiết kế sang trọng.', 35000000000.00, 'Vũng Tàu', 'Villa', 'Available', 4, 2, '2024-12-05 10:49:46', '2024-12-05 12:38:38', '50');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `property_details`
--

CREATE TABLE `property_details` (
  `id` bigint(20) NOT NULL,
  `pcontent` longtext NOT NULL,
  `type` varchar(255) NOT NULL,
  `bhk` varchar(255) NOT NULL,
  `stype` varchar(255) NOT NULL,
  `bedroom` int(11) NOT NULL,
  `bathroom` int(11) NOT NULL,
  `balcony` int(11) NOT NULL,
  `kitchen` int(11) NOT NULL,
  `hall` int(11) NOT NULL,
  `floor` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `location` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `totalfloor` varchar(255) NOT NULL,
  `properties_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `property_details`
--

INSERT INTO `property_details` (`id`, `pcontent`, `type`, `bhk`, `stype`, `bedroom`, `bathroom`, `balcony`, `kitchen`, `hall`, `floor`, `price`, `location`, `city`, `state`, `totalfloor`, `properties_id`) VALUES
(1, 'Quý vị đang xem nội dung tin rao \"Chính chủ kẹt tiền bán gấp lô đất cắt lỗ 200tr\" - Mã tin 38597297. Mọi thông tin, nội dung liên quan tới tin rao này là do người đăng tin đăng tải và chịu trách nhiệm. Batdongsan.com.vn luôn cố gắng để các thông tin được hữu ích nhất cho quý vị tuy nhiên Batdongsan.com.vn không đảm bảo và không chịu trách nhiệm về bất kỳ thông tin, nội dung nào liên quan tới tin rao này. Trường hợp phát hiện nội dung tin đăng không chính xác, Quý vị hãy thông báo và cung cấp thông tin cho Ban quản trị Batdongsan.com.vn theo Hotline 19001881 để được hỗ trợ nhanh và kịp thời nhất.', 'house', '4', 'sale', 4, 2, 0, 1, 1, '2nd floor', 1869, '124 cu chi', 'ho chi minh', 'viet nam', '2', 1);

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
  `buyer_id` bigint(20) NOT NULL,
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
(2, 3, 1, 2, '2024-02-01 08:00:00', 5000000000.00, 'Completed');

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
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `phone`, `role`, `created_at`) VALUES
(1, 'Nguyễn Văn A', 'nguyenvana@gmail.com', 'password123', '0987654321', 'User', '2024-12-05 10:49:40'),
(2, 'Trần Thị B', 'tranthib@gmail.com', 'password456', '0987654322', 'User', '2024-12-05 10:49:40'),
(3, 'Admin', 'admin@batdongsan.com', 'admin123', '0987654323', 'Admin', '2024-12-05 10:49:40');

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
-- AUTO_INCREMENT cho bảng `properties`
--
ALTER TABLE `properties`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `property_details`
--
ALTER TABLE `property_details`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
