-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2017 at 03:22 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE perpustakaan2;
--
-- Database: `perpustakaan2`
--

-- --------------------------------------------------------
USE perpustakaan2;

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id` int(4) NOT NULL,
  `no_anggota` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `nama` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `jk` varchar(15) COLLATE latin1_general_ci NOT NULL,
  `telp` varchar(15) COLLATE latin1_general_ci NOT NULL,
  `alamat` varchar(100) COLLATE latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`id`, `no_anggota`, `nama`, `jk`, `telp`, `alamat`) VALUES
(1, 'A-1', 'Irfan Gerard Wicaksono Mokalu', 'Laki-laki', '08521206212', 'Villa Mutiara Pluit C8/53 kec/kel periuk Tangerang, Banten'),
(2, 'A-2', 'Ilham Prahyuda', 'Laki-laki', '098984747', 'Kos - kosan bagus banget'),
(3, 'A-3', 'Muhammad Rizky OSB', 'Laki-laki', '0898333988', 'Tanjung Periuk, jakarta Utara');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id` int(5) NOT NULL,
  `kode` varchar(15) COLLATE latin1_general_ci NOT NULL,
  `judul` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `pengarang` varchar(35) COLLATE latin1_general_ci NOT NULL,
  `penerbit` varchar(35) COLLATE latin1_general_ci NOT NULL,
  `isbn` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `stok` int(4) NOT NULL,
  `kategori_id` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id`, `kode`, `judul`, `pengarang`, `penerbit`, `isbn`, `stok`, `kategori_id`) VALUES
(1, 'Kal-ku-lus-1', 'Kalkulus I', 'Siapa ya', 'Penerbit Buku', '9848484', 15, 1),
(2, 'Kal-ku-lus-2', 'Kalkulus II', 'Siapa ya', 'Penerbit Buku', '09848484', 30, 1),
(4, 'Fi-si-ka-I', 'Fisika I', 'Marmud', 'Maxindo', '90983738', 86, 1),
(5, 'Fi-si-ka-II', 'Fisika II', 'Marmud', 'Maxindo', '90983738', 78, 1);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id` int(4) NOT NULL,
  `nama` varchar(50) COLLATE latin1_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id`, `nama`) VALUES
(1, 'Kuliah Wajib'),
(2, 'Kuliah Pilihan'),
(3, 'Praktikum'),
(4, 'Kucing');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` int(4) NOT NULL,
  `no_pinjam` varchar(15) COLLATE latin1_general_ci NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date NOT NULL,
  `anggota_id` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `no_pinjam`, `tgl_pinjam`, `tgl_kembali`, `anggota_id`) VALUES
(1, 'P1412-1', '2014-12-09', '2014-12-19', 1),
(2, 'P1412-2', '2014-12-08', '2014-12-09', 2),
(3, 'P1214-3', '2014-12-30', '2014-12-31', 3),
(4, 'P1214-4', '2014-12-30', '2014-12-31', 2),
(5, 'P1214-5', '2014-12-30', '2014-12-31', 1),
(6, 'P0115-6', '2015-01-06', '2015-01-07', 3),
(7, 'P0115-7', '2015-01-06', '2015-01-07', 2);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman_detail`
--

CREATE TABLE `peminjaman_detail` (
  `id_pinjam` int(4) NOT NULL,
  `id_buku` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `peminjaman_detail`
--

INSERT INTO `peminjaman_detail` (`id_pinjam`, `id_buku`) VALUES
(6, 4),
(6, 2),
(7, 5),
(7, 4);

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(4) NOT NULL,
  `nama` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `telp` varchar(15) COLLATE latin1_general_ci NOT NULL,
  `alamat` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `username` varchar(35) COLLATE latin1_general_ci NOT NULL,
  `password` varchar(35) COLLATE latin1_general_ci NOT NULL,
  `hak_akses` varchar(30) COLLATE latin1_general_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `nama`, `telp`, `alamat`, `username`, `password`, `hak_akses`) VALUES
(3, 'Irfan Gerard Wicaksono Mokalu', '0', 'Tanjung Seneng', 'Irfan', 'Mokalu', 'Admin'),
(4, 'Ayu', '0', 'Kedaton', 'ayu', 'ayu', 'Operator');

-- --------------------------------------------------------

--
-- Table structure for table `setting`
--

CREATE TABLE `setting` (
  `max_buku` int(2) NOT NULL,
  `batas_pinjam` int(2) NOT NULL,
  `denda` double NOT NULL,
  `banyak_pinjam` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Dumping data for table `setting`
--

INSERT INTO `setting` (`max_buku`, `batas_pinjam`, `denda`, `banyak_pinjam`) VALUES
(3, 1, 3000, 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
